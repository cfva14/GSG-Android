package org.b12x.gfe.utilities

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileManagement {

    val directoryManagement = DirectoryManagement()

    fun doesFileExist(pathInQuestion: String): Boolean {
        return Files.exists(Paths.get(pathInQuestion))
    }

    fun createFile(whereTheFileShouldGo: String, fileName: String, fileSuffix: String, overwriteFile: Boolean) {
        var pathToFile = whereTheFileShouldGo

        // check the path for a slash at the end before adding file
        if (whereTheFileShouldGo.elementAt(whereTheFileShouldGo.length - 1).toString() != "/") {
            pathToFile = "$whereTheFileShouldGo/"
        }

        // create folder
        directoryManagement.createFolder(pathToFile, false)

        // create file
        val newFileString = "$pathToFile$fileName.$fileSuffix"
        File(newFileString).createNewFile()
    }

    fun createDataFile(loci: String, locus: String, version: String) {
        val pathToFile = directoryManagement.createDataFolder(loci, version)
        val fileName = "$locus-$version-Download"

        createFile(pathToFile, fileName, "csv", false)
    }
}