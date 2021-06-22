package org.b12x.gfe

import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val textAreas by cssclass()
    }

    init {
        root {
            prefHeight = 600.px
            prefWidth = 800.px
        }

        textAreas {
            padding = box(20.px)
            prefWidth = 760.px
            prefHeight = 300.px
        }

        textField {
            prefWidth = 25.px
//            borderWidth += box(30.px, 30.px, 30.px, 30.px)
        }

        label and heading {
//            padding = box(100.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}