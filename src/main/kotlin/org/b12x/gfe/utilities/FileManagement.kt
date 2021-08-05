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

    fun createADataFile(loci: String, locus: String, version: String) {

        directoryManagement.createDataFolder(loci, version)
//        var pathToFile = whereTheFileShouldGo
//
//        // check the path for a slash at the end before adding file
//        if (whereTheFileShouldGo.elementAt(whereTheFileShouldGo.length - 1).toString() != "/") {
//            pathToFile = whereTheFileShouldGo + "/"
//        }
//
//        // so as not to overwrite the file, check if it already exists
//        if (!doesFileExist(pathToFile + fileName)) {
//            Files.createFile(Paths.get(pathToFile + fileName))
//        }
    }
}