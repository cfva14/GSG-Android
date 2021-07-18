package org.b12x.gfe.utilities

import java.io.File

class DirectoryManagement {

    val USER_DIRECTORY = System.getProperty("user.home")


    fun doesFolderExist(pathInQuestion: String): Boolean {
        return File(pathInQuestion).exists()
    }

    fun createDataFolder(loci: String, newFolder: String) {
        val dataFolder = when (loci) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData/"
            }
        }
        val finalPath = USER_DIRECTORY + dataFolder + newFolder

    }
}