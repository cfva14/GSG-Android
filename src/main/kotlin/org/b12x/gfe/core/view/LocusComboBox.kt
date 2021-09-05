package org.b12x.gfe.core.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.utilities.locus.HlaLoci
import org.b12x.gfe.plugins.gfesearch.view.GfeLayoutData
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchView
import org.b12x.gfe.utilities.preference.Prefs
import org.b12x.gfe.utilities.preference.PrefsOld
import tornadofx.*
import kotlin.collections.ArrayList

class LocusComboBox : View("My View") {

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
                find(GfeSearchView::class).swapSearchBoxes(GfeLayoutData.selectedLocus)
            }
        }
    }
}
