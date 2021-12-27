package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ListChangeListener
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.LociStateContextGfeSearch
import tornadofx.*
import tornadofx.Stylesheet.Companion.empty

class GfeSearchComboBoxVersion : View("My View") {

    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch
    var versionList: VersionList = VersionList(stateContext.getLoci())
    var versions: List<String> = versionList.allVersionNames
    var versionsObservableList: ObservableList<String> = FXCollections.observableArrayList(versions)

    init {
        versionsObservableList.addListener { _: ListChangeListener.Change<out String>? ->
            comboBoxVersion.apply {
                versions = versionsObservableList
                println("This is what is currently in the observable list: $versions")
                println("This is what the choicebox thinks is in its list: ${this.items}")
                currentVersion = stateContext.getCurrentVersion()
                println("currentVersion changed: $currentVersion")
            }
//            GfeSearchViewParent.swapVersionComboBox()
        }
    }

    val currentVersionProperty = SimpleStringProperty(stateContext.getCurrentVersion()) // No default needed
    var currentVersion: String by currentVersionProperty// Nullable String

    var comboBoxVersion = choicebox<String>(currentVersionProperty, versionsObservableList) {
        action {
            if (this.value != null) {
                stateContext.setCurrentVersion(currentVersion)
            }

            println("currentVersion according to Context = " + stateContext.getCurrentVersion())
            println("currentVersion according to choicebox = " + currentVersionProperty)
////            Prefs.currentGfeSearchVersion = this.value
////            GfeSearchLayoutData.selectedVersion = SimpleStringProperty(this.value)
//////                GfeSearchLayoutData.resetArraysHard()
//////                swapSearchBoxes(GfeLayoutData.selectedLocus)
        }
    }

    override var root = hbox {
        add(comboBoxVersion)
    }


}
