package org.b12x.gfe.utilities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DirectoryManagementTest {

    val directoryManagement = DirectoryManagement()
    val GSGDATA = "Documents/GSG/GSGData/"
    val HLA_TEST = "/Documents/GSG/GSGData/HLA/Test/"
    val NON_EXSISTENT_DIRECTORY = "/Documents/GSG/GSGData/HLA/Test24/"
    val CHAINED_NON_EXSISTENT_DIRECTORIES = "/Documents/GSG/GSGData/TEST2/TestingSomeMore"
    val TESTING_FOLDER = "TestFolder"
    val USER_DIRECTORY = System.getProperty("user.home")

    @Test
    fun lookingForFolder() {
        assertTrue(directoryManagement.doesFolderExist("$USER_DIRECTORY$HLA_TEST"))
        assertFalse(directoryManagement.doesFolderExist("$USER_DIRECTORY$NON_EXSISTENT_DIRECTORY"))
    }

    @Test
    fun creatingDataFolder() {
        directoryManagement.createDataFolder("TEST", TESTING_FOLDER)
        directoryManagement.createDataFolder("HLA", TESTING_FOLDER)
        directoryManagement.createDataFolder("TEST2", "TestingSomeMore")
        assertTrue(directoryManagement.doesFolderExist(USER_DIRECTORY + GSGDATA + "TEST" + TESTING_FOLDER))
        assertTrue(directoryManagement.doesFolderExist(USER_DIRECTORY + GSGDATA + "HLA" + TESTING_FOLDER))
        assertTrue(directoryManagement.doesFolderExist(USER_DIRECTORY + CHAINED_NON_EXSISTENT_DIRECTORIES))
    }
}