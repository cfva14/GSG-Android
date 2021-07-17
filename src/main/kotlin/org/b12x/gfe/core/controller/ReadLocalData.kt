package org.b12x.gfe.core.controller

import java.io.File

class ReadLocalData(loci: String) {

    var GSG_FOLDER: String = setLoci(loci)
    val USER_DIRECTORY = System.getProperty("user.home")
    var DATA_FOLDERS = ArrayList<File>()

    fun setLoci(lociGroup: String): String {
        val newFolder = when (lociGroup) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData"
            }
        }
        return newFolder
    }

    fun getSubFolders(): List<File> {
        print(USER_DIRECTORY)
        val tempArray = File(USER_DIRECTORY + GSG_FOLDER)//.listFiles(File(".DS_Store"))
//        tempArray.forEach { DATA_FOLDERS.add(File(it.name)) }
        DATA_FOLDERS.add(File("Test"))

        return DATA_FOLDERS
    }
}