package org.b12x.gfe.utilities

import java.io.File
import java.nio.file.Files.createDirectories
import java.nio.file.Paths

class DirectoryManagement {

    private val lociLocations = LociLocations()

    fun doesFolderExist(pathInQuestion: String): Boolean {
        return File(pathInQuestion).exists()
    }

    fun createFolder(pathToCreate: String, overwriteFolder: Boolean) {
        if (overwriteFolder) {
            File(pathToCreate).deleteRecursively()
        }

        createDirectories(Paths.get(pathToCreate))
    }

    fun createDataFolder(loci: String, version: String): String {
        val finalPath = lociLocations.determineLociFolder(loci) + version

        // it won't overwrite the old directories or files
        createDirectories(Paths.get(finalPath))

        return finalPath
    }

    fun removeFolder(pathToRemove: String) {

        // removes all contents and folder itself
        File(pathToRemove).deleteRecursively()
    }
}