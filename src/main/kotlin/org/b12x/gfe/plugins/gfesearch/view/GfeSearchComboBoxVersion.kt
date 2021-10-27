package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.core.controller.VersionList
import org.b12x.gfe.core.controller.locistate.LociStateContext
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class GfeSearchComboBoxVersion : View("My View") {

    private val lociStateContext = GfeSearchLayoutData.gfeSearchLociStateContext
    private val versionList = VersionList(lociStateContext.getIdentity())
    val versions = observableListOf(versionList.allVersionNames.sortedDescending())

//    init {
//        val readLocalData = ReadLocalData("HLA")
//        val versionsFile = readLocalData.returnOnlineVersionFile()
//        versionsFile.forEachLine {
//            versions.add(it)
//        }
//    }

    var currentVersion by property(
        SimpleStringProperty(GfeSearchLayoutData.selectedVersion)
    )

    val comboBoxVersion = choicebox<String>(currentVersion, versions) {
        action {
            Prefs.currentGfeSearchVersion = this.value
//                GfeSearchLayoutData.resetArraysHard()
//                swapSearchBoxes(GfeLayoutData.selectedLocus)
        }
    }

    override val root = hbox {
        add(comboBoxVersion)
    }


}
