package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.core.controller.ReadLocalData
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class GfeSearchComboBoxVersion : View("My View") {

    private val versions = ArrayList<String>()

    init {
        val readLocalData = ReadLocalData("HLA")
        val versionsFile = readLocalData.returnOnlineVersionFile()
        versionsFile.forEachLine {
            versions.add(it)
        }
    }

    var currentVersion by property(
        SimpleStringProperty(GfeSearchLayoutData.selectedVersion)
    )

    override val root = hbox {
        choicebox<String>(currentVersion, versions) {
            action {
//                GfeSearchLayoutData.selectedLocus = HlaLoci.values().find { it.fullName == this.value } ?: HlaLoci.A
                Prefs.currentGfeSearchVersion = this.value
//                GfeSearchLayoutData.resetArraysHard()
//                swapSearchBoxes(GfeLayoutData.selectedLocus)
            }
        }
    }


}
