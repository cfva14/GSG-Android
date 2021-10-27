package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.layout.HBox
import org.b12x.gfe.core.view.ComboBoxLoci
import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val locusComboBox = GfeSearchComboBoxLocus()
    private val lociComboBox = ComboBoxLoci("GfeSearch")
    var gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(GfeSearchLayoutData.selectedLocus)
    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = hbox {
            add(lociComboBox.root)
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