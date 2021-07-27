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
        // redundant, but won't let me alter whereTheFileShouldGo if there's a missing slash
        var pathToFile = whereTheFileShouldGo

        // check the path for a slash at the end before adding file
        if (whereTheFileShouldGo.elementAt(whereTheFileShouldGo.length - 1).toString() != "/") {
            pathToFile = whereTheFileShouldGo + "/"
        }
        // create folder
        directoryManagement.createFolder(pathToFile, true)

//         check if file already exists, and/or overwrite is true
        if (!doesFileExist(pathToFile + fileName)) {
            Files.createFile(Paths.get("$pathToFile$fileName.$fileSuffix"))
        } else if (doesFileExist(pathToFile + fileName) && overwriteFile) {
            File("$pathToFile$fileName.$fileSuffix").delete()
            Files.createFile(Paths.get("$pathToFile$fileName.$fileSuffix"))
        } else {
            Files.createFile(Paths.get(pathToFile + fileName + "_1." + fileSuffix))
        }
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