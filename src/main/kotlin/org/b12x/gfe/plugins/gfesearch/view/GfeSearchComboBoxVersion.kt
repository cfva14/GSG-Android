package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.LociStateContextGfeSearch
import tornadofx.*
import tornadofx.Stylesheet.Companion.empty

class GfeSearchComboBoxVersion : View("My View"), ComboBoxVersion {

    //    private val lociStateContext = GfeSearchLayoutData.gfeSearchLociStateContext
//    var loci: SimpleStringProperty = GfeSearchLayoutData.selectedLociGroup
    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch
    override var versionList: VersionList = VersionList(stateContext.getLoci())
    override val versions: ObservableList<String> = observableListOf(versionList.allVersionNames)

    override val currentVersion: SimpleStringProperty by property(stateContext.getCurrentVersion())
//    SimpleStringProperty by property(
//        GfeSearchLayoutData.selectedVersion
//    )

    override val comboBoxVersion = choicebox<String>(currentVersion, versions) {
        action {
            if (this.value != null) {
                stateContext.setCurrentVersion(this.value)
            }
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
