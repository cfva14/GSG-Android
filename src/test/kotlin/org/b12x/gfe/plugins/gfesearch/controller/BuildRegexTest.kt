package org.b12x.gfe.plugins.gfesearch.controller

import com.sun.tools.javac.util.List.from
import javafx.beans.Observable
import org.b12x.gfe.plugins.gfesearch.view.TestLayout
import org.b12x.gfe.utilities.preference.PrefsManager
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream
import tornadofx.*


class BuildRegexTest {

    val testLayout = TestLayout()
    val textFields = testLayout.textFields
    val checkBoxes = testLayout.checkBoxes

    @Test
    fun getIntDefault() {
        assertEquals(0, 0)
    }

    companion object ArgumentsParameters {

        @BeforeAll
        @JvmStatic
        internal fun setup() {

//            Observable.
//            for (textFields)
            PrefsManager.wipePref("TESTING_INT");
            PrefsManager.wipePref("TESTING_STRING");
            PrefsManager.wipePref("TESTING_BOOLEAN");
        }

        @JvmStatic
        fun snakeCaseArguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of("addUp", "ADD_UP"),
                Arguments.of("SlowDown", "SLOW_DOWN"),
                Arguments.of("word", "WORD"),
                Arguments.of("TEST_ME", "TEST_ME")
            )

        @JvmStatic
        fun intArguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(3, 3, 9),
                Arguments.of(2, 3, 6)
            )
    }
}

