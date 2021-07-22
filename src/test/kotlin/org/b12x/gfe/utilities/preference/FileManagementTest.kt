package org.b12x.gfe.utilities.preference

import org.b12x.gfe.utilities.DirectoryManagement
import org.b12x.gfe.utilities.FileManagement
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileManagementTest {

    val directoryManagement = DirectoryManagement()
    val fileManagement = FileManagement()
    val GSGDATA = "/Documents/GSG/GSGData"
    val USER_DIRECTORY = System.getProperty("user.home")
    val TESTING_FOLDER = "3.31.0"
    val TEST_FILE_1 = "neo4j_HLA-A_3.31.0_Download.csv"
    val TEST_FILE_2 = "neo4j_HLA-DRB1_3.31.0_Download.csv"
    val TEST_FILE_3 = "neo4j_HLA-A_3.31.0_Download.csv"
    val NESTED_NON_EXSISTENT_DIRECTORIES = "/Documents/GSG/GSGData/TEST2/3.31.0/"


    @Test
    fun createFile() {
        fileManagement.createAFile((USER_DIRECTORY + GSGDATA + "/TEST2/" + TESTING_FOLDER), TEST_FILE_1, true)
        fileManagement.createAFile((USER_DIRECTORY + GSGDATA + "/TEST2/" + TESTING_FOLDER), TEST_FILE_2, true)
        fileManagement.createAFile((USER_DIRECTORY + GSGDATA + "/TEST2/" + TESTING_FOLDER), TEST_FILE_3, true)
        Assertions.assertFalse(fileManagement.doesFileExist(USER_DIRECTORY + GSGDATA + "/TEST2/" + TESTING_FOLDER))
        Assertions.assertFalse(fileManagement.doesFileExist(USER_DIRECTORY + NESTED_NON_EXSISTENT_DIRECTORIES))
    }

    companion object ArgumentsParameters {

        @BeforeEach
//        @JvmStatic
        internal fun setup() {
            val GSG_DATA_FOLDER = System.getProperty("user.home") + "/Documents/GSG/GSGData"
            File(GSG_DATA_FOLDER + "/TEST3/").deleteRecursively()
            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST3/"))
            File(GSG_DATA_FOLDER + "/TEST2/").deleteRecursively()
            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST2/"))
        }

        @AfterAll
        @JvmStatic
        internal fun takedown() {
//            val GSG_DATA_FOLDER = System.getProperty("user.home") + "/Documents/GSG/GSGData"
//            File(GSG_DATA_FOLDER + "/TEST3/").deleteRecursively()
//            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST3/"))
//            File(GSG_DATA_FOLDER + "/TEST2/").deleteRecursively()
//            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST2/"))
        }
    }
}