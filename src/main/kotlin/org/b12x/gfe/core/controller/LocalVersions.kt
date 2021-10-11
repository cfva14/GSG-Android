package org.b12x.gfe.core.controller

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.ParserVersionData
import org.b12x.gfe.utilities.FileManagement
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.fileSize

class LocalVersions(loci: String) {

    private val gsgFolder: String = setLoci(loci)
    private val userDirectory = System.getProperty("user.home")
    private val gsgDataLocation = File(userDirectory + gsgFolder)
    private val headerLength = 50  // bytes

    val dataFolders = ArrayList<Version>()

    /**
     * Sets the specific group of genes to be read.
     *
     * @return a string of the path to the appropriate data folder
     */
    fun setLoci(lociGroup: String): String {
        return when (lociGroup) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData/"
            }
        }
    }

    /**
     * Gets all subfolders for a specific set of genes in the user's GSG data directory.
     *
     * @return a list of folder names
     */
    fun getVersionFolderNames(): ArrayList<String> {
        var lociAvailable = ArrayList<String>()
        gsgDataLocation.listFiles().forEach {
            if (it.exists() and it.isDirectory and folderContainsData(it)) {
//                val version = Version(it.name.toString(), lociAvailable)
//                dataFolders.add(version)
            }
        }
        return lociAvailable
    }

    // Move this
    fun returnOnlineVersionFile(): File {
        val onlineVersionsFile = userDirectory + gsgFolder + "onlineVersions.txt"
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

    // If any file contains data, the parent folder should be added to the list
    private fun folderContainsData(folder: File) =
        folder.listFiles().any { fileContainsData(it) }

    // A file with only a header and no data is 50 bytes or fewer
    // (usually 18, but this gives some leeway to change the header)
    private fun fileContainsData(file: File) = file.length() > headerLength

    // get the locus name out of the file name
    private fun locusName(fileName: String) = fileName.split("_")[1]

//     HlaLoci.values().find { it.fullName == locusName(fileName) }
// GfeSearchComboBoxLocus.kt ln 26
}