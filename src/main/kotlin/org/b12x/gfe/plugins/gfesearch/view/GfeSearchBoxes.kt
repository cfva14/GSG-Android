package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import org.b12x.gfe.plugins.gfesearch.controller.GfeData
import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes") {

    val currentSearchData = GfeData()
    // TODO - is this where I want to instantiate the data class?

    val numberOfSearchBoxes = 8
    val completedSearchBox = completedSearchBoxGenerator(numberOfSearchBoxes)

    override val root = hbox {
        add(completedSearchBox)
        style {
            padding = box(25.px)
        }
    }

    private fun completedSearchBoxGenerator(numberOfBoxes: Int): HBox {
        val completedSearchBox = hbox { }

        completedSearchBox.add(Group(individualSearchBoxAssembler("Workshop Status")))
        completedSearchBox.add(Group(individualSearchBoxAssembler("5' UTR")))

        for (i in 1 until numberOfBoxes) {
            completedSearchBox.add(Group(individualSearchBoxAssembler("Exon $i")))
            completedSearchBox.add(Group(individualSearchBoxAssembler("Intron $i")))
        }

        completedSearchBox.add(Group(individualSearchBoxAssembler("Exon $numberOfBoxes")))
        completedSearchBox.add(Group(individualSearchBoxAssembler("3' UTR")))

        return completedSearchBox
    }

    private fun individualSearchBoxAssembler(labelName: String): VBox {
        lateinit var currentCheckBox: CheckBox
        lateinit var currentTextField: TextField

        val rotatedLabel = label(labelName) {
            style {
                rotate = 90.deg
                padding = box(0.px, 0.px, 0.px, 10.px)
            }
        }

        val searchBoxComponent = vbox {
            currentCheckBox = checkbox { }
            currentTextField = textfield {
                style {
                    prefWidth = 40.px
//                    maxHeight = 30.px
                    padding = box(0.px, 5.px, 10.px, 5.px)
//                    padding = box(0.px, 0.px, 0.px, 0.px)
                }
            }

            style {
                maxWidth = 60.px
                alignment = Pos.CENTER
                padding = box(0.px, 5.px, 0.px, 5.px)
            }
        }
        searchBoxComponent.add(Group(rotatedLabel))

        currentSearchData.checkArray.add(currentCheckBox)
        currentSearchData.textArray.add(currentTextField)

        return searchBoxComponent
    }


//    val set2 = vbox {
//        checkbox { }
//        textfield {
//            style {
//                padding = box(0.px, 0.px, 0.px, 0.px)
//            }
//        }
//        label("Exon 1") {
//            style {
//                rotate = 90.deg
//                padding = box(0.px, 0.px, 0.px, 40.px)
//            }
//        }
//        style {
//            alignment = Pos.CENTER
//        }
//    }


}
