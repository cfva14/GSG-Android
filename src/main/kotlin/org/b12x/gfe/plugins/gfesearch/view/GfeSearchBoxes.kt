package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes"){
    private val searchBox: SearchBox by inject()

    override val root = hbox {
//        for (i in 0..9) {
//            val i = searchBox.root
//            this += i
                add(searchBox.root)
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
            }
        }
        style {
            alignment = Pos.CENTER
        }
    }
}
