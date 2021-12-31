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

class GfeSearchChoiceBoxVersion : View("My View") {

    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch
    var versionList: VersionList = VersionList(stateContext.getLoci())
    var versions: List<String> = versionList.allVersionNames
    var versionsObservableList: ObservableList<String> = FXCollections.observableArrayList(versions)

    val currentVersionProperty = SimpleStringProperty(stateContext.getCurrentVersion()) // No default needed
    var currentVersion: String by currentVersionProperty// Nullable String

    var comboBoxVersion = choicebox<String>(currentVersionProperty, versionsObservableList) {
        action {
            if (this.value != null) {
                stateContext.setCurrentVersion(this.value)
                currentVersion = this.value
            }
        }
    }

    override var root = hbox {
        add(comboBoxVersion)
    }


}
