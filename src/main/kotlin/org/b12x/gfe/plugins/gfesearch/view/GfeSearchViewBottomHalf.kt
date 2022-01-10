package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*
import kotlin.system.exitProcess

class GfeSearchViewBottomHalf : View() {

    private val gfeSearchButtonSubmit: GfeSearchButtonSubmit by inject()
    private val gfeSearchTableView = GfeSearchTableView("CSV")


    override val root = borderpane {
        top = hbox {  }

        center = vbox {
            add(gfeSearchTableView.root)
        }

        bottom = vbox {
            add(gfeSearchButtonSubmit.root)
            add(button("Exit") {
                setOnAction { exitProcess(0) }
            })
        }

    }
}