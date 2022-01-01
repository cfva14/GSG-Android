package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.PrefsGfeSearch
import tornadofx.*

class GfeSearchChoiceBoxLoci(whichTab: String) : View("Available Loci") {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR")
    var stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    private val currentLociProperty = SimpleStringProperty(stateContext.getLoci()) // No default needed
    private var currentLoci: String by currentLociProperty// Nullable String

    private val choiceBoxLoci = choicebox<String>(currentLociProperty, loci) {
        action {
            PrefsGfeSearch.currentGfeSearchLociGroup = this.value
            stateContext.setState(this.value)
            stateContext.updateVersions()
            stateContext.updateLocus()
            GfeSearchLayoutData.resetArraysHard()
            find(GfeSearchChoiceBoxLocus::class).swapSearchBoxes(stateContext.getCurrentLocus())
        }
    }

    override val root = hbox {
        add(choiceBoxLoci)
    }
}
