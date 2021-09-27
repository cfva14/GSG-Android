package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.Parent
import tornadofx.*
import kotlin.system.exitProcess

class GfeSearchBottomHalf : View() {

    private val gfeSearchSubmitButton: GfeSearchSubmitButton by inject()
    private val gfeSearchVersionComboBox: GfeSearchVersionComboBox by inject()

    override val root = borderpane {
        top = hbox {
            add(gfeSearchVersionComboBox.root)
        }

        center = vbox {}

        bottom = vbox {
            add(gfeSearchSubmitButton.root)
            add(button("Exit") {
                setOnAction { exitProcess(0) }
            })
        }

    }
}