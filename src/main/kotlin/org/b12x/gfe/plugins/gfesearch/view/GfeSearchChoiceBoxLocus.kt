package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.b12x.gfe.core.controller.loci.LociEnum
import tornadofx.*

class GfeSearchChoiceBoxLocus : View() {

    private val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    private var locusNames : List<String> = stateContext.getCurrentLocusNamesList()
    var locusObservableList: ObservableList<String> = FXCollections.observableArrayList(locusNames)

    private val currentLocusProperty = SimpleStringProperty(stateContext.getCurrentLocus().toString())
    var currentLocus: String by currentLocusProperty

    private var choiceBoxLocus = choicebox<String>(currentLocusProperty, locusObservableList) {
        action {
            if (this.value != null) {
                stateContext.setCurrentLocus(this.value)
                currentLocus = this.value
            }
            GfeSearchLayoutData.resetArraysHard()
            swapSearchBoxes(stateContext.getCurrentLocus())
        }
    }

    override val root = hbox {
        add(choiceBoxLocus)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus passed to it.
    fun swapSearchBoxes(loci: LociEnum) {
        find(GfeSearchViewParent::class).gfeSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchBoxes = stateContext.createNewSearchBoxes()
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchBoxes)
    }
}
