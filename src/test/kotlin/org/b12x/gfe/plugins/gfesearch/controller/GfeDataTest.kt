package org.b12x.gfe.plugins.gfesearch.controller

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.plugins.gfesearch.view.TestApp
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll

class GfeDataTest {
    val emptyGfeData = GfeData()
//    val testApp = TestApp()

    @Test
    fun getDefaultGfeData() {
        assertEquals(ArrayList<CheckBox>(), emptyGfeData.checkArray)
        assertEquals(ArrayList<TextField>(), emptyGfeData.textArray)
        assertEquals("", emptyGfeData.regex)
        assertEquals("CSV", emptyGfeData.textFormat)
        assertEquals(false, emptyGfeData.writeToFile)
        assertTrue(emptyGfeData.checkArray.isEmpty())
        assertTrue(emptyGfeData.textArray.isEmpty())
    }

//    @Test
//    fun testTestApp() {
//        assertEquals()
//    }

}