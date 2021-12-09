package org.b12x.gfe.utilities

import java.io.File
import java.nio.file.Files.createDirectories
import java.nio.file.Paths

class DirectoryManagement {

    /**
     * Checks for the existence of a folder.
     *
     * @param pathInQuestion the path to the folder to check
     * @return whether or not the folder exists
     */
    fun doesFolderExist(pathInQuestion: String): Boolean {
        return File(pathInQuestion).exists()
    }

    /**
     * Checks to see if there's anything in the folder.
     *
     * @param pathInQuestion the path to the folder to check
     * @return if the folder contains anything.
     */
    fun doesFolderContainFiles(pathInQuestion: String): Boolean {
        val files = File(pathInQuestion).list()
        return files.isNotEmpty()
    }

    /**
     * Creates a new folder.
     *
     * @param pathToCreate the path to the folder
     * @param overwriteFolder option to allow a preexisting folder to be overwritten
     * @return path to folder
     */
    fun createFolder(pathToCreate: String, overwriteFolder: Boolean): String {
        if (overwriteFolder) {
            File(pathToCreate).deleteRecursively()
        }

        createDirectories(Paths.get(pathToCreate))
        return pathToCreate
    }

    /**
     * Creates a data folder.
     * This is non-destructive and will not overwrite a pre-existing
     * folder or any files it contains.
     *
     * @param loci which group of genes the folder is for
     * @param version which version of the database is the folder is for
     * @return string of the created path
     */
    fun createDataFolder(loci: String, version: String): String {
        val finalPath = setLociLocation(loci) + version

        // it won't overwrite the old directories or files
        createDirectories(Paths.get(finalPath))

        return finalPath
    }

    /**
     * Deletes a folder.
     *
     * @param pathToRemove the path to the folder to delete
     */
    fun removeFolder(pathToRemove: String) {

        // removes all contents and folder itself
        File(pathToRemove).deleteRecursively()
    }

    private val userDirectory = System.getProperty("user.home")

    /**
     * Sets the specific group of genes to be read.
     *
     * @params a string representing the target loci
     * @return a string to the location of the specified data directory
     */
    fun setLociLocation(loci: String) = when (loci) {
        "HLA" -> "$userDirectory/Documents/GSG/GSGData/HLA/"
        "KIR" -> "$userDirectory/Documents/GSG/GSGData/KIR/"
        "ABO" -> "$userDirectory/Documents/GSG/GSGData/ABO/"
        "TEST" -> "$userDirectory/Documents/GSG/GSGData/TEST/"
        else -> {
            "$userDirectory/Documents/GSG/GSGData/$loci/"
        }
    }
}