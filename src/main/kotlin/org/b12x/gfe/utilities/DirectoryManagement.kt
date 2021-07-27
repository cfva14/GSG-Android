package org.b12x.gfe.utilities

import java.io.File
import java.nio.file.Files.createDirectories
import java.nio.file.Paths

class DirectoryManagement {

    val USER_DIRECTORY = System.getProperty("user.home")

    fun determineParentLociFolder(loci: String): String {
        val dataFolder = when (loci) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData/$loci/"
            }
        }
        return USER_DIRECTORY + dataFolder
    }

    fun doesFolderExist(pathInQuestion: String): Boolean {
        return File(pathInQuestion).exists()
    }

    fun createFolder(pathToCreate: String, overwriteFolder: Boolean) {
        // check if file already exists, and/or overwrite is true
        if (!doesFolderExist(pathToCreate) || overwriteFolder) {
            createDirectories(Paths.get(pathToCreate))
        } else {
            createDirectories(Paths.get(pathToCreate +"_1"))
        }
    }

    fun createDataFolder(loci: String, version: String) {

        val finalPath = Paths.get( determineParentLociFolder(loci) + version)

        // we don't care if it overwrites the old files
        createDirectories(finalPath)
    }

    fun removeFolder(pathToRemove: String) {

        // removes all contents and folder itself
        File(pathToRemove).deleteRecursively()
    }
}