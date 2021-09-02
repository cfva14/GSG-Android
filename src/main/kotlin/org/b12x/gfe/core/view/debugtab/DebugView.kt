package org.b12x.gfe.core.view.debugtab

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import org.b12x.gfe.Styles
import tornadofx.*
import kotlin.system.exitProcess

class DebugView : View("Debug") {

    private val calcOptions = FXCollections.observableArrayList("Enumerated", "Sealed")
    private val selectedCalc = SimpleStringProperty(calcOptions.get(0))
    private val debuggerTextArea = textarea() {

    }

    override val root = stackpane {
        borderpane {

            top = combobox<String>(selectedCalc, calcOptions)

            center = vbox {
                add(debuggerTextArea)
            }

            bottom = hbox {
                add(button("Exit") {
                    setOnAction { exitProcess(0) }
                })
                add(button("Do Something") {
                    setOnAction {
                        debuggerTextArea.appendText("Do Something!\n")
                        println("Do Something!")
                    }
                })
            }
        }
        addClass(Styles.textAreas)
    }
}
