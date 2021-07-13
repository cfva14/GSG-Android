package org.b12x.gfe.utilities.preference

import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class PrefsTest {

    private val prefs = Prefs()

    @Test
    fun getIntDefault() {
        assertEquals(0, prefs.testingInt)
    }

    @Test
    fun getStringDefault() {
        assertEquals("", prefs.testingString)
    }

    @Test
    fun getBooleanDefault() {
        assertEquals(false, prefs.testingBoolean)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun setGetIntTest(num: Int) {
        prefs.testingInt = num
        assertEquals(num, prefs.testingInt)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Air", "BETA", "cdef", ""])
    fun setGetStringTest(word: String) {
        prefs.testingString = word
        assertEquals(word, prefs.testingString)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun setGetBooleanTest(boolean: Boolean) {
        prefs.testingBoolean = boolean
        assertEquals(boolean, prefs.testingBoolean)
    }

    companion object ArgumentsParameters {

        @BeforeAll
        @JvmStatic
        internal fun setup() {
            PrefsManager.wipePref("TESTING_INT");
            PrefsManager.wipePref("TESTING_STRING");
            PrefsManager.wipePref("TESTING_BOOLEAN");
        }
    }
}