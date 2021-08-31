package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.core.view.LocusComboBox
import org.b12x.gfe.utilities.locus.HlaLoci
import tornadofx.*
import kotlin.system.exitProcess

class GfeSearchView : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")
    private var lociOptions = ArrayList<String>()
    init {
        HlaLoci.values().forEach { lociOptions.add(it.fullName) }
    }

    private val locusComboBox = LocusComboBox()
    private var gfeSearchBoxes = GfeSearchBoxes(HlaLoci.A)
    private val gfeSearchSubmitButton: GfeSearchSubmitButton by inject()

    override val root = borderpane {
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

    fun swapSearchBoxes(loci: HlaLoci) {
        gfeSearchBoxes.removeFromParent()
        gfeSearchBoxes = GfeSearchBoxes(loci)
        this.root.center.add(gfeSearchBoxes)
        println("GfeSearchView.swapSearchBoxes triggered")
    }
}