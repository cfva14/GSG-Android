package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import org.b12x.gfe.core.view.LocusComboBox
import org.b12x.gfe.plugins.gfesearch.controller.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*
import kotlin.system.exitProcess

class GfeSearchView : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")
    val prefs = Prefs()
    private var lociOptions = ArrayList<String>()
    private val lociRaw = HlaLoci.values().forEach { lociOptions.add(it.fullName) } //.associateBy(HlaLoci::fullName)

    private val locusComboBox = LocusComboBox()
    private val gfeSearchBoxes: GfeSearchBoxes by inject()
//    private val selectedCalc = SimpleStringProperty(lociOptions[0])
    private val gfeSearchSubmitButton: GfeSearchSubmitButton by inject()

    override val root = borderpane {
//        top = combobox<String> (null, lociOptions)
        top = locusComboBox.root

        center = vbox {
            add(gfeSearchBoxes.root)
//            add( hbox {
//                add(button("Add") { setOnAction { println("You pressed button \"Add\"") } })
//                add(button("Multiply") { setOnAction { println("You pressed button \"Multiply\"") } })
//                add(button("Equals") { setOnAction { println("You pressed button \"Equals\"") } })
//            })
        }

        bottom = vbox {
            add(gfeSearchSubmitButton.root)
            add(button("Exit") {
                setOnAction { exitProcess(0) }
            })
        }
        style {
            padding = box(25.px)
        }
    }

//    override val root = vbox {
//        add(combobox<String> (selectedCalc, calcOptions))

//        add(vbox {
//            add(gfeSearchBoxes.root)
//            add( hbox {
//                add(button("Add") { setOnAction { println("You pressed button \"Add\"") } })
//                add(button("Multiply") { setOnAction { println("You pressed button \"Multiply\"") } })
//                add(button("Equals") { setOnAction { println("You pressed button \"Equals\"") } })
//            })
//        })
//
//        add(hbox {
//            add(gfeSearchSubmitButton)
//        })
//    }
    init {
//        selectedCalc.onChange { println("Calculator changed to: $it") }
    }
}