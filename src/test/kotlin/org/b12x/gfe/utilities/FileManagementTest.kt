package org.b12x.gfe.utilities

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileManagementTest {

    val fileManagement = FileManagement()
    val GSG_DATA = "/Documents/GSG/GSGData"
    val USER_DIRECTORY = System.getProperty("user.home")
    val TESTING_FOLDER_W_SLASH = "/TEST2/output/"
    val TESTING_FOLDER_WO_SLASH = "/TEST2/output"
    val TEST_FILE_1 = "HLA-A_3.31.0_2019-12-19_11-28-48"
    val TEST_FILE_2 = "HLA-B_3.31.0_2018-12-19_11-28-48"
    val TEST_FILE_3 = "HLA-C_3.31.0_2017-12-19_11-28-48"
    val TEST_DATA_FILE_1_CSV = "HLA-A-3.31.0-Download.csv"
    val TEST_DATA_FILE_2_CSV = "HLA-DRB1-3.31.0-Download.csv"
    val RAW_DATA_DIRECTORIES = "/Documents/GSG/GSGData/TEST3/3.31.0/"

    // Hard to test for. I look at the time stamps in the folder to confirm they have not been overwritten.
    // Documents/GSG/GSGData/TEST2/output/
    // The csv file gives the first time stamp, the tsv the second time stamp.
    // The text file's time stamp should match the csv file's to pass.
    // The time in question should be the creation time.
    // Comment out the @AfterAll in the companion object or the test results will be deleted.
    // Uncomment the 1 minute thread sleep to run properly.
    @Test
    fun doesNotOverwriteAFile() {
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "csv", true)
//        Thread.sleep(60_000)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "txt", true)
        fileManagement.createFile("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH", TEST_FILE_1, "tsv", true)
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.txt"))
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$GSG_DATA$TESTING_FOLDER_W_SLASH$TEST_FILE_1.csv"))
    }

    @Test
    fun doesTheFileExist() {
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

    @Test
    fun createADataFile() {
        fileManagement.createDataFile("TEST3", "HLA-A", "3.31.0")
        fileManagement.createDataFile("TEST3", "HLA-DRB1", "3.31.0")
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$RAW_DATA_DIRECTORIES$TEST_DATA_FILE_1_CSV"))
        assertTrue(fileManagement.doesFileExist("$USER_DIRECTORY$RAW_DATA_DIRECTORIES$TEST_DATA_FILE_2_CSV"))
    }

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
            File("$GSG_DATA_FOLDER/TEST3/").deleteRecursively()
            Files.deleteIfExists(Paths.get("$GSG_DATA_FOLDER/TEST3/"))
            File("$GSG_DATA_FOLDER/TEST2/").deleteRecursively()
            Files.deleteIfExists(Paths.get("$GSG_DATA_FOLDER/TEST2/"))
        }
    }
}