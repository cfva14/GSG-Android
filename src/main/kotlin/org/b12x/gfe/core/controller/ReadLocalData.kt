package org.b12x.gfe.core.controller

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.ParserVersionData
import org.b12x.gfe.utilities.FileManagement
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class ReadLocalData(loci: String) {

    var GSG_FOLDER: String = setLoci(loci)
    val USER_DIRECTORY = System.getProperty("user.home")
    var dataFolders = ArrayList<String>()

    /**
     * Sets the specific group of genes to be read.
     *
     * @return a string of the path to the appropriate data folder
     */
    fun setLoci(lociGroup: String): String {
        GSG_FOLDER = when (lociGroup) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData/"
            }
        }
        return GSG_FOLDER
    }

    /**
     * Gets all subfolders for a specific set of genes in the user's GSG data directory.
     *
     * @return a list of folder names
     */
    fun getSubFolderNames(): List<String> {
        val gsgDataLocation = File(USER_DIRECTORY + GSG_FOLDER)
        println(gsgDataLocation)

        gsgDataLocation.listFiles().forEach {
            if (it.exists() and it.isDirectory) {
                dataFolders.add(it.name.toString())
            }
        }

        println(dataFolders)

        return dataFolders
    }

    fun returnOnlineVersionFile(): File {
        val onlineVersionsFile = USER_DIRECTORY + GSG_FOLDER + "onlineVersions.txt"
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

//    private fun

}