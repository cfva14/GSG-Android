package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*
import kotlin.system.exitProcess

class GfeSearchViewBottomHalf : View() {

    private val gfeSearchButtonSubmit: GfeSearchButtonSubmit by inject()
    private val gfeSearchComboBoxVersion: GfeSearchComboBoxVersion by inject()

    override val root = borderpane {
        top = hbox {
            add(gfeSearchComboBoxVersion.root)
        }

        center = vbox {}

        bottom = vbox {
            add(gfeSearchButtonSubmit.root)
            add(button("Exit") {
                setOnAction { exitProcess(0) }
            })
        }

    }
}