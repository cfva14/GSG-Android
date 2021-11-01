package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.utilities.Loci
import org.b12x.gfe.utilities.getHlaLoci
import tornadofx.*

class GfeSearchComboBoxLocus : View(), ComboBoxLocus {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    override var locusNames : List<String> = getHlaLoci().mapNotNull { it.toString() }

    override var currentLocus: SimpleStringProperty by property(
        SimpleStringProperty(GfeSearchLayoutData.selectedLocus.toString())
    )

    override var comboBoxLocus = choicebox<String>(currentLocus, locusNames) {
        action {
//            GfeSearchLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
//            Prefs.currentGfeSearchLocus = this.value
//            GfeSearchLayoutData.resetArraysHard()
//            swapSearchBoxes(GfeSearchLayoutData.selectedLocus)
        }
    }

    override val root = vbox {
        add(comboBoxLocus)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    private fun swapSearchBoxes(loci: Loci) {
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(loci)
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes)
    }

    fun swapLocusChoiceBox() {}
}
