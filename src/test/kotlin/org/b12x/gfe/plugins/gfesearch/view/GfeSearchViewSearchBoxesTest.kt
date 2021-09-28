package org.b12x.gfe.plugins.gfesearch.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class GfeSearchViewSearchBoxesTest {
    val gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes()
//    val dataClass = gfeSearchBoxes.currentSearchData
    val numberOfSearchBoxes = 3

    @Test
    fun completedSearchBoxGenerator_returns_hbox() {
//        assertEquals(HBox::class, gfeSearchBoxes.completedSearchBoxGenerator(numberOfSearchBoxes)::class)
//        assertEquals(numberOfSearchBoxes, dataClass.checkArray.size)
//        assertEquals(numberOfSearchBoxes, dataClass.textArray.size)
    }

    @Test
    fun individualSearchBoxAssembler_returns_vbox() {
//        assertEquals(VBox::class, gfeSearchBoxes.individualSearchBoxAssembler("Test1")::class)
//        assertEquals(numberOfSearchBoxes + 1, dataClass.checkArray.size)
//        assertEquals(numberOfSearchBoxes + 1, dataClass.textArray.size)
    }

    @ParameterizedTest
    @MethodSource("intronExonLabelArguments")
    fun labelGenerator_returns_appropriateLabel(i: Int, label: String) {
//        assertEquals(label, gfeSearchBoxes.labelGenerator(i))
    }

    companion object ArgumentsParameters {

//        @BeforeAll
//        @JvmStatic
//        internal fun setup() {
//            launch<MyApp>()
//        }

        @JvmStatic
        fun intronExonLabelArguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of(0, "Workshop Status"),
                Arguments.of(1, "5' UTR"),
                Arguments.of(2, "Exon 1"),
                Arguments.of(3, "Intron 1"),
                Arguments.of(4, "Exon 2"),
                Arguments.of(5, "Intron 2"),
                Arguments.of(6, "Exon 3"),
                Arguments.of(7, "Intron 4"),
                Arguments.of(8, "Exon 5"),
                Arguments.of(9, "3' UTR")
            )
    }
}