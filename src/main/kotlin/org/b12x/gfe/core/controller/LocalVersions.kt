package org.b12x.gfe.core.controller

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.ParserVersionData
import org.b12x.gfe.utilities.FileManagement
import org.b12x.gfe.utilities.setLociLocation
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists

class LocalVersions(loci: String) {

    private val gsgDataLocation = setLociLocation(loci) // setLociLocation(loci)
    private val headerLength = 50  // bytes

    val versionsList = createVersions()

    /**
     * Gets all versions for a specific set of genes in the user's GSG data directory.
     *
     * @return a list of versions available locally
     */
    fun createVersions(): ArrayList<Version> {//ArrayList<String> {

        val versions = ArrayList<Version>()
        // if the folder doesn't exist, there's nothing to add.
        if (Paths.get(gsgDataLocation).exists() and File(gsgDataLocation).isDirectory) {
            File(gsgDataLocation).listFiles().forEach {

                // make sure we're looking at folders, that they have files in them
                // and what they have in them actually contains data
                if (it.exists() and it.isDirectory and folderContainsData(it)) {
                    val locusAvailable = getLocusAvailable(it)
                    val version = Version(it, it.name.toString(), locusAvailable)
                    versions.add(version)
                }
            }
        }
        return versions
    }

    /**
     * Gets all available locus names for a specific version
     * Gets all files for a specific version of genes in the user's GSG data directory.
     *
     * @return a list of locus names
     */
    private fun getLocusAvailable(folder: File): ArrayList<String> {//ArrayList<String> {
        var allLocusAvailable = ArrayList<String>()

        if (folder.isDirectory) {
            folder.listFiles().forEach {
                if (fileContainsData(it)) {
                    allLocusAvailable.add(locusName(it))
                }
            }
        }
        return allLocusAvailable
    }

    // Check to see if there are any files in the folder with data in them
    // It doesn't matter how many
    private fun folderContainsData(folder: File): Boolean {
        if (folder.exists() and folder.isDirectory) {
            return folder.listFiles().any { fileContainsData(it) }
        }
        return false
    }

    // A file with only a header and no data is 50 bytes or fewer
    // (usually 18, but this gives some leeway to change the header)
    private fun fileContainsData(file: File) = file.length() > headerLength

    // get the locus name out of the file name
    private fun locusName(file: File) = file.toString().split("_")[1]


    fun returnOnlineVersionFile(): File {
        val onlineVersionsFile = gsgDataLocation + "onlineVersions.txt"
        if (FileManagement.doesFileExist(onlineVersionsFile)) {
            return File(onlineVersionsFile)
        }
        runBlocking {
            launch {
                val dataDownload = DataDownload("HLA")
                dataDownload.makeRequest(dataType = "version", dataUrl = ParserVersionData.DB_VERSIONS)
            }
        }

        return File(onlineVersionsFile)
    }
}