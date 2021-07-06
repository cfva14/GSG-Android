package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes"){
    private val searchBox: SearchBox by inject()

    override val root = hbox {
//        for (i in 0..9) {
//            val i = searchBox.root
//            this += i
        add(searchBox.root)
        add(searchBox.set2)
//        }
    }
}

class SearchBox : View() {
    override val root = vbox {
        checkbox {  }
        textfield {  }
        label("Intron 1") {
            style {
                rotate = 90.deg
                paddingLeft = 40
            }
        }
        style {
            alignment = Pos.CENTER
        }
    }


    fun completedSearchBoxGenerator(): HBox {
        val completedSearchBox =  hbox { }

        return completedSearchBox
    }

    fun individualSearchBoxAssembler(): VBox {
        val searchBoxComponent = vbox { }

        return searchBoxComponent
    }

    val set2 = vbox {
        checkbox {  }
        textfield {
            style {
                padding = box(0.px, 0.px, 0.px, 0.px)
            }
        }
        label("Exon 1") {
            style {
                rotate = 90.deg
                padding = box(0.px, 0.px, 0.px, 40.px)
            }
        }
        style {
            alignment = Pos.CENTER
        }
    }



}
