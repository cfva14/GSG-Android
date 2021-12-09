package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val locusComboBox = GfeSearchComboBoxLocus()
    private val versionComboBox = GfeSearchComboBoxVersion()
    private val lociComboBox = GfeSearchComboBoxLoci("GfeSearch")
    var gfeSearchBoxes = GfeSearchViewSearchBoxesHla(HlaLoci.A)


    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    fun startingSearchBoxes() {
        // put in a blank box and run switch? Will it do it without it?

    }

    override val root = borderpane {
        top = hbox {
            add(lociComboBox.root)
            add(versionComboBox.root)
            add(locusComboBox.root)

            style {

            }
        }

        center = vbox {
            add(gfeSearchBoxes.root)
        }

        bottom = gfeSearchViewBottomHalf.root

        style {
            padding = box(25.px)
        }
    }
}