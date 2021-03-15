package org.b12x.gfe.core.view.debugtab

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*
import kotlin.system.exitProcess

class DebugView : View("Debug") {

    private val calcOptions = FXCollections.observableArrayList("Enumerated", "Sealed")
    private val selectedCalc = SimpleStringProperty(calcOptions.get(0))

    override val root = borderpane {

        top = combobox<String>(selectedCalc, calcOptions)

        center = vbox {
            textarea () { //textarea (documentViewModel.text)
                this.prefWidthProperty().bind(this@borderpane.widthProperty());
                this.prefHeightProperty().bind(this@borderpane.heightProperty());
            }
        }

        bottom = vbox {
            add(button("Exit") {
                setOnAction { exitProcess(0) }
            })
        }
    }
}
