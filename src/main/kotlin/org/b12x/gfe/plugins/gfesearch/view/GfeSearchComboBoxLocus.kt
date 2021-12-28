package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchComboBoxLocus : View(), ComboBoxLocus {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    override var locusNames : List<String> = stateContext.getCurrentLocusNamesList()

    override var currentLocus: SimpleStringProperty by property(
        SimpleStringProperty(stateContext.getCurrentLocus().toString())
    )

    override var comboBoxLocus = choicebox<String>(currentLocus, locusNames) {
        action {
            stateContext.setCurrentLocus(this.value)
            GfeSearchLayoutData.resetArraysHard()
            swapSearchBoxes(GfeSearchLayoutData.selectedLocus)
        }
    }

    override val root = vbox {
        add(comboBoxLocus)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    private fun swapSearchBoxes(loci: LociEnum) {
        find(GfeSearchViewParent::class).gfeSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchBoxes = stateContext.createNewSearchBoxes()
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchBoxes)
    }

    fun swapLocusChoiceBox() {}
}
