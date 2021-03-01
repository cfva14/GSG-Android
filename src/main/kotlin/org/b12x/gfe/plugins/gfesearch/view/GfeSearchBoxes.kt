package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes"){
    private val searchBox: SearchBox by inject()

    override val root = hbox {
//        for (i in 0..9) {
//            add(searchBox)
//        }
    }
}

class SearchBox : Fragment() {
    override val root = borderpane {
        top = checkbox {  }
        center = textfield {  }
        bottom = label("Intron 1") {
            style {
                rotate = 90.deg
            }
        }
    }
}
