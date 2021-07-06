package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import org.b12x.gfe.plugins.gfesearch.controller.GfeData
import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes") {
//    val searchBox: SearchBox by inject()

    //    override val root = hbox {
////        for (i in 0..9) {
////            val i = searchBox.root
////            this += i
//        add(searchBox.root)
//        add(searchBox.set2)
////        }
//    }
//}
//
//class SearchBox : View() {
//    val searchBox: SearchBox by inject()

    val currentSearchData = GfeData()
    val numberOfSearchBoxes = 3
    val completedSearchBox = completedSearchBoxGenerator(numberOfSearchBoxes)
//    val searchBoxes = completedSearchBox by inject()

    override val root = hbox {
        add(completedSearchBox)

//        checkbox { }
//        textfield { }
//        label("Intron 1") {
//            style {
//                rotate = 90.deg
//                paddingLeft = 40
//            }
//        }
//        style {
//            alignment = Pos.CENTER
//        }
    }


    fun completedSearchBoxGenerator(numberOfBoxes: Int): HBox {
        val completedSearchBox = hbox { }
        for(i in 1..numberOfBoxes) {
            completedSearchBox.add(individualSearchBoxAssembler(i.toString()))
        }

        return completedSearchBox
    }

    fun individualSearchBoxAssembler(labelName: String): VBox {
        lateinit var currentCheckBox: CheckBox
        lateinit var currentTextField: TextField
        val searchBoxComponent = vbox {
            currentCheckBox = checkbox { }
            currentTextField = textfield {
                style {

                }
            }
            label(labelName) {
                style {
                    rotate = 90.deg
                    padding = box(0.px, 0.px, 0.px, 40.px)
                    textAlignment = TextAlignment.LEFT
                }
            }
            style {
                alignment = Pos.CENTER
            }
        }
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
