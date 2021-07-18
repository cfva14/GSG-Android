package org.b12x.gfe.core.controller

import java.io.File

class ReadLocalData(loci: String) {

    var GSG_FOLDER: String = setLoci(loci)
    val USER_DIRECTORY = System.getProperty("user.home")
    var DATA_FOLDERS = ArrayList<File>()

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
     * @return a list of files
     */
    fun getSubFolders(): List<File> {
        print(USER_DIRECTORY)

//        DATA_FOLDERS= File(USER_DIRECTORY + GSG_FOLDER).listFiles().toList()
//        val tempArray = File(USER_DIRECTORY + GSG_FOLDER).listFiles().toList()
//        tempArray.forEach { DATA_FOLDERS.add(File(it.name)) }
        DATA_FOLDERS.add(File("Test1"))

        return DATA_FOLDERS
    }


}