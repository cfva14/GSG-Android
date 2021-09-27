package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.utilities.locus.HlaLoci
import tornadofx.*

class GfeSearchView : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val locusComboBox = GfeSearchLocusComboBox()
    var gfeSearchBoxes = GfeSearchBoxes(GfeLayoutData.selectedLocus)
    private val gfeSearchBottomHalf = GfeSearchBottomHalf()

    override val root = borderpane {
        top = locusComboBox.root

        center = vbox {
            add(gfeSearchBoxes.root)
        }

        bottom = gfeSearchBottomHalf.root

        style {
            padding = box(25.px)
        }
    }
}