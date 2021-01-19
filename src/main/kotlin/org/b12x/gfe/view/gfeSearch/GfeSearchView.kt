package org.b12x.gfe.view.gfeSearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*

class GfeSearchView : View("GFE SEARCH") {

    private val calcOptions = FXCollections.observableArrayList("Enumerated", "Sealed")
//    private val numButtons = find(NumButtons::class)
    private val selectedCalc = SimpleStringProperty(calcOptions.get(0))

    override val root = borderpane {
        top = combobox<String> (selectedCalc, calcOptions)

        center = vbox {
//            add(numButtons)
            add( hbox {
                add(button("Add") { setOnAction { println("You pressed button \"Add\"") } })
                add(button("Multiply") { setOnAction { println("You pressed button \"Multiply\"") } })
                add(button("Equals") { setOnAction { println("You pressed button \"Equals\"") } })
            })
        }

        bottom = label("answer goes here")
    }

    init {
        selectedCalc.onChange { println("Calculator changed to: $it") }
    }
}