package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.utilities.locus.HlaLoci
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

    override val root = vbox {
        choicebox<String>(currentLocus, lociNames) {
            action {
                GfeSearchLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
                Prefs.currentGfeSearchLocus = this.value
                GfeSearchLayoutData.resetArraysHard()
                swapSearchBoxes(GfeSearchLayoutData.selectedLocus)
            }
        }
    }

    fun swapSearchBoxes(loci: HlaLoci) {
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(loci)
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes)
        println("GfeSearchView.swapSearchBoxes triggered")
    }
}
