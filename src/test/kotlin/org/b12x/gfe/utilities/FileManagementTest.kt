package org.b12x.gfe.utilities

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileManagementTest {

    val directoryManagement = DirectoryManagement()
    val fileManagement = FileManagement()
    val GSG_DATA = "/Documents/GSG/GSGData"
    val USER_DIRECTORY = System.getProperty("user.home")
    val TESTING_FOLDER_W_SLASH = "/TEST2/output/"
    val TESTING_FOLDER_WO_SLASH = "/TEST2/output"
    val TEST_FILE_1 = "HLA-A_3.31.0_2019-12-19_11-28-48"
    val TEST_FILE_2 = "HLA-B_3.31.0_2018-12-19_11-28-48"
    val TEST_FILE_3 = "HLA-C_3.31.0_2017-12-19_11-28-48"
    val REPEAT_TEST_FILE_1 = "HLA-B_3.31.0_2019-12-19_11-28-48_1"
    val TEST_DATA_FILE_1_CSV = "neo4j_HLA-A_3.31.0_Download.csv"
    val TEST_DATA_FILE_2_CSV = "neo4j_HLA-DRB1_3.31.0_Download.csv"
    val TEST_DATA_FILE_3_CSV = "neo4j_HLA-B_3.31.0_Download.csv"
    val REPEAT_TEST_DATA_FILE_1_CSV = "neo4j_HLA-A_3.31.0_Download_1.csv"
    val NESTED_NON_EXSISTENT_DIRECTORIES = "/Documents/GSG/GSGData/TEST2/3.31.0/"

    @Test
    fun doesFileExist() {
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.txt"))
    }

    @Test
    fun createAFile() {
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_WO_SLASH", TEST_FILE_2, "csv", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_WO_SLASH", TEST_FILE_3, "tsv", true)
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.txt"))
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_2.csv"))
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_3.tsv"))
    }

    @Test // hard to test for. I look at the time stamps in the folder to confirm they have not been overwritten.
    fun doesNotOverwriteAFile() {
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "csv", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.txt"))
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.csv"))
    }

//    @Test
//    fun createASecondFile() {
//        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
//        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", false)
//        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", false)
//        Assertions.assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH/$TEST_FILE_1.txt"))
//        Assertions.assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH/$TEST_FILE_1" + "_1.txt"))
//        Assertions.assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH/$TEST_FILE_1" + "_1_1.txt"))
//    }

    @BeforeEach
    internal fun setup() {
        val GSG_DATA_FOLDER = System.getProperty("user.home") + "/Documents/GSG/GSGData"
        File("$GSG_DATA_FOLDER/TEST2").deleteRecursively()
    }

    companion object ArgumentsParameters {

        @AfterAll
        @JvmStatic
        internal fun takedown() {
            val GSG_DATA_FOLDER = System.getProperty("user.home") + "/Documents/GSG/GSGData"
            File(GSG_DATA_FOLDER + "/TEST3/").deleteRecursively()
            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST3/"))
            File(GSG_DATA_FOLDER + "/TEST2/").deleteRecursively()
            Files.deleteIfExists(Paths.get(GSG_DATA_FOLDER + "/TEST2/"))
        }
    }
}