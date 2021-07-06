package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream
import tornadofx.*

class GfeSearchBoxesTest {
    val gfeSearchBoxesClass = GfeSearchBoxes()
    val searchBox = SearchBox()

    @Test
    fun completedSearchBoxGenerator_returns_hbox() {
        assertEquals(HBox(), searchBox.completedSearchBoxGenerator())
    }

    @Test
    fun individualSearchBoxAssembler_returns_vbox() {
        assertEquals(VBox(), searchBox.individualSearchBoxAssembler())
    }

}