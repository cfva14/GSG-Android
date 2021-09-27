package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.utilities.locus.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*
import kotlin.collections.ArrayList

class GfeSearchLocusComboBox : View() {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    private val lociNames = ArrayList<String>()

    init {
        HlaLoci.values().forEach { lociNames.add(it.toString()) }
    }

    var foo by property(SimpleStringProperty(GfeLayoutData.selectedLocus.toString()))

    override val root = vbox {
            choicebox<String>(foo, lociNames) {
            action {
                GfeLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
                Prefs.currentGfeSearchLocus = this.value
                GfeLayoutData.resetArraysHard()
                swapSearchBoxes(GfeLayoutData.selectedLocus)
            }
        }
    }

    fun swapSearchBoxes(loci: HlaLoci) {
        find(GfeSearchView::class).gfeSearchBoxes.removeFromParent()
        find(GfeSearchView::class).gfeSearchBoxes = GfeSearchBoxes(loci)
        find(GfeSearchView::class).root.center.add(find(GfeSearchView::class).gfeSearchBoxes)
        println("GfeSearchView.swapSearchBoxes triggered")
    }
}
