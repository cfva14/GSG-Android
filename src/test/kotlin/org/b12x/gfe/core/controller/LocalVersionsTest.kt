package org.b12x.gfe.core.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.io.walk


class LocalVersionsTest {

    val TEST = "/Documents/GSG/GSGData/HLA/Test/"
    val GSGDATA = "Documents/GSG/GSGData/"
    val userDirectory = System.getProperty("user.home")

    val localVersions = LocalVersions("TEST")


    @Test
    fun testVariables() {
        println("Directory: $userDirectory$TEST")
        File(userDirectory + TEST).walk().forEach { println(it.name) }
    }

    @Test
    fun changeLoci() {
        localVersions.setLoci("HLA")
        assertEquals("/Documents/GSG/GSGData/HLA/", localVersions.GSG_FOLDER)
        localVersions.setLoci("TEST")
        assertEquals("/Documents/GSG/GSGData/TEST/", localVersions.GSG_FOLDER)
    }

    @Test
    fun listFolders() {
        localVersions.setLoci("TEST")
        val localFiles = listOf("Test", "3.34.0", "3.35.0")
        assertEquals(localFiles, localVersions.getSubFolderNames())
    }

    @Test
    fun listFiles() {
//        getLocalFiles(userDirectory + TEST).forEach { println(it.name) /}
    }




//    val testLayout = TestLayout()
//    val textFields = testLayout.textFields
//    val checkBoxes = testLayout.checkBoxes
//
//    @Test
//    fun getIntDefault() {
//        assertEquals(textFields.size, checkBoxes.size)
//    }
//
//    companion object ArgumentsParameters {
//
//        @BeforeAll
//        @JvmStatic
//        internal fun setup() {
////            runAsync {
//                launch<TestApp>()
////            }
////            textFields.forEach {
////
////            }
////            PrefsManager.wipePref("TESTING_INT");
////            PrefsManager.wipePref("TESTING_STRING");
////            PrefsManager.wipePref("TESTING_BOOLEAN");
//        }
//
//        @AfterAll
//        @JvmStatic
//        internal fun after() {
////            TestApp.parentStage.hide()
////            exitProcess(0) //<TestApp>()
//        }
//
//        @JvmStatic
//        fun snakeCaseArguments(): Stream<Arguments> =
//            Stream.of(
//                Arguments.of("addUp", "ADD_UP"),
//                Arguments.of("SlowDown", "SLOW_DOWN"),
//                Arguments.of("word", "WORD"),
//                Arguments.of("TEST_ME", "TEST_ME")
//            )
//
//        @JvmStatic
//        fun intArguments(): Stream<Arguments> =
//            Stream.of(
//                Arguments.of(2, 2, 4),
//                Arguments.of(3, 3, 9),
//                Arguments.of(2, 3, 6)
//            )
//    }
}

