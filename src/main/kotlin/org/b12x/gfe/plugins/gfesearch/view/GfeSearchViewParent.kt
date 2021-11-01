package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val locusComboBox = GfeSearchComboBoxLocus()
    private val versionComboBox = GfeSearchComboBoxVersion()
    private val lociComboBox = GfeSearchComboBoxLoci("GfeSearch")
    var gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(GfeSearchLayoutData.selectedLocus)
    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = hbox {
            add(lociComboBox.root)
            add(versionComboBox.root)
            add(locusComboBox.root)

            style {

            }
        }

        center = vbox {
            add(gfeSearchViewSearchBoxes.root)
        }

        bottom = gfeSearchViewBottomHalf.root

        style {
            padding = box(25.px)
        }
    }
}