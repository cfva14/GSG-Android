package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*
import javafx.scene.control.Button

class GfeSearchSubmitButton : View("Submit") {
    private val resultsTextField = textfield("Nothing to display")

    override val root = vbox {
        button("Submit") {
            action {
                GfeLayoutData.resetArraysSoft()
                println("You pressed the GFE Search submit button.")
                resultsTextField.text = "Data submitted"
            }
        }
        add(resultsTextField)
    }
}

//action {
//    GfeLayoutData.resetArraysSoft()
//    runAsync {
//        myController.loadText()
//        setOnAction {
//            GfeLayoutData.resetArraysSoft()
//            println("You pressed the GFE Search submit button.")
//        }
//     } ui {
//          resultsTextField.text = "Data submitted"
//     }
//}