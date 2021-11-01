package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class GfeSearchComboBoxVersion : View("My View"), ComboBoxVersion {

    //    private val lociStateContext = GfeSearchLayoutData.gfeSearchLociStateContext
    var loci: SimpleStringProperty = GfeSearchLayoutData.selectedLociGroup
    override var versionList: VersionList = VersionList(loci.toString())
    override var versions: ObservableList<String> = observableListOf(versionList.allVersionNames.sortedDescending())

    override var currentVersion: SimpleStringProperty by property(
        GfeSearchLayoutData.selectedVersion
    )

    override val comboBoxVersion = choicebox<String>(currentVersion, versions) {
        action {
//            Prefs.currentGfeSearchVersion = this.value
//            GfeSearchLayoutData.selectedVersion = SimpleStringProperty(this.value)
////                GfeSearchLayoutData.resetArraysHard()
////                swapSearchBoxes(GfeLayoutData.selectedLocus)
        }
    }

    override val root = hbox {
        add(comboBoxVersion)
    }


}
