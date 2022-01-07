package org.b12x.gfe.utilities

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object FileManagement {

    //make an extension function on files to create them

    val directoryManagement = DirectoryManagement()

    /**
     * Checks for the existence of a file.
     *
     * @param pathInQuestion the path to the file to check
     * @return whether or not the file exists
     */
    fun doesFileExist(pathInQuestion: String): Boolean {
        return Files.exists(Paths.get(pathInQuestion))
    }

    /**
     * Creates a new file if one does not exist.
     *
     * @param whereTheFileShouldGo the path to the file to create
     * @param fileName the name of the file
     * @param fileSuffix the type of file
     * @return the path to the file
     */
    fun createFile(whereTheFileShouldGo: String, fileName: String, fileSuffix: String): String {
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

        return newFileString
    }

    /**
     * Creates a data file.
     *
     * This will overwrite a prior datafile.
     *
     * @param loci which group of genes the data is for
     * @param locus the specific gene the data is for
     * @param version which version of the database is the data retrieved from
     */
    fun createDataFile(loci: String, locus: String, version: String) {
        val pathToFile = directoryManagement.createDataFolder(loci, version)
        val fileName = "$locus-$version-Download"

        createFile(pathToFile, fileName, "csv")
    }

    /**
     * Deletes a file.
     *
     * @param pathToFile the path to the file to delete
     */
    fun deleteFile(pathToFile: String) {
        if (doesFileExist(pathToFile)) {
            File(pathToFile).delete()
        }
    }
}