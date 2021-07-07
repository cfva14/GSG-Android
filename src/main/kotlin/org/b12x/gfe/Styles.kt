package org.b12x.gfe

import javafx.scene.text.Font
import javafx.scene.text.Font.font
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val textAreas by cssclass()
    }

    init {

        root {
            prefHeight = 600.px
            prefWidth = 1000.px
            fontFamily = "sansserif"
        }

        textAreas {
            padding = box(20.px)
            prefWidth = 760.px
            prefHeight = 300.px
        }

        textField {
            prefWidth = 25.px
            textAlignment = TextAlignment.CENTER
//            borderWidth += box(30.px, 30.px, 30.px, 30.px)
        }

        label and heading {
//            padding = box(100.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
    }
}