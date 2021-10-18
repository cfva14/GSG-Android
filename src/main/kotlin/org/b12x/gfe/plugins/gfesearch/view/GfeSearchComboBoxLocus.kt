package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.utilities.loci.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*
import kotlin.collections.ArrayList

class GfeSearchComboBoxLocus : View() {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val lociNames = ArrayList<String>()

    init {
        HlaLoci.values().forEach { lociNames.add(it.toString()) }
    }

    var currentLocus by property(
        SimpleStringProperty(GfeSearchLayoutData.selectedLocus.toString())
    )


    var comboBoxLocus = choicebox<String>(currentLocus, lociNames) {
        action {
            GfeSearchLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
            Prefs.currentGfeSearchLocus = this.value
            GfeSearchLayoutData.resetArraysHard()
            swapSearchBoxes(GfeSearchLayoutData.selectedLocus)
        }
    }

    override val root = vbox {
        add(comboBoxLocus)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    private fun swapSearchBoxes(loci: HlaLoci) {
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(loci)
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes)
    }

    fun swapLocusChoiceBox() {}
}
