package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.PrefsGfeSearch
import tornadofx.*

class GfeSearchChoiceBoxLoci(whichTab: String) : View("Available Loci") {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR")
    var stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    var currentLoci: SimpleStringProperty by property(GfeSearchLayoutData.selectedLociGroup)

    val choiceBoxLoci = choicebox<String>(currentLoci, loci) {
        action {
            PrefsGfeSearch.currentGfeSearchLociGroup = this.value
            stateContext.setState(this.value)
            stateContext.updateVersions()
        }
    }

    override val root = hbox {
        add(choiceBoxLoci)
    }
}
