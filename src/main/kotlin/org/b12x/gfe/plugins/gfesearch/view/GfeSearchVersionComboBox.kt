package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.utilities.locus.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class GfeSearchVersionComboBox : View("My View") {

    private val versions = ArrayList<String>()

    init {
        HlaLoci.values().forEach { versions.add(it.toString()) }
    }

    var currentVersion by property(
        SimpleStringProperty(Prefs.currentGfeSearchVersion)
    )

    override val root = hbox {
        choicebox<String>(currentVersion, versions) {
            action {
                GfeLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
                Prefs.currentGfeSearchVersion = this.value
                GfeLayoutData.resetArraysHard()
//                swapSearchBoxes(GfeLayoutData.selectedLocus)
            }
        }
    }


}
