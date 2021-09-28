package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val locusComboBox = GfeSearchComboBoxLocus()
    var gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(GfeSearchLayoutData.selectedLocus)
    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = locusComboBox.root

        center = vbox {
            add(gfeSearchViewSearchBoxes.root)
        }

        bottom = gfeSearchViewBottomHalf.root

        style {
            padding = box(25.px)
        }
    }
}