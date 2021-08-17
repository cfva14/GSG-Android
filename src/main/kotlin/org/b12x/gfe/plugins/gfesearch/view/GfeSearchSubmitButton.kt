package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*
import javafx.scene.control.Button

class GfeSearchSubmitButton : View("Submit") {
    private val resultsTextField = textfield("Nothing to display")

    override val root = vbox {
        button("Update text") {
            action {
                runAsync {
//                  myController.loadText()
                    GfeLayoutData.resetArraysSoft()
                    setOnAction { println("You pressed the GFE Search submit button.") }
                } ui {
                    resultsTextField.text = "Data submitted"
                }
            }
        }
        add(resultsTextField)
    }
}
