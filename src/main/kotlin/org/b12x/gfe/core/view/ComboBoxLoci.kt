package org.b12x.gfe.core.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import org.b12x.gfe.core.controller.locistate.LociStateContext
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewSearchBoxes
import org.b12x.gfe.utilities.Loci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class ComboBoxLoci(whichTab: String) : View("Available Loci") {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR", "TEST")
    var gfeSearchLociStateContext = GfeSearchLayoutData.gfeSearchLociStateContext

    var currentLoci by property(
        when (whichTab) {
            "GfeSearch" -> GfeSearchLayoutData.selectedLociGroup
//            "NameSearch" -> SimpleStringProperty(NameSearchLayoutData.selectedLociGroup.toString())
//            "Comparison" -> SimpleStringProperty(ComparisonLayoutData.selectedLociGroup.toString())
//            "Options" -> SimpleStringProperty(OptionsLayoutData.selectedLociGroup.toString())
//            "Debug" -> SimpleStringProperty(DebugLayoutData.selectedLociGroup.toString())
            else -> {
                SimpleStringProperty(GfeSearchLayoutData.selectedLociGroup.toString())
            }
        }
    )

    val comboBoxLoci = choicebox<String>(currentLoci, loci) {
        action {
            when (whichTab) {
                "GfeSearch" -> Prefs.currentGfeSearchLociGroup = this.value
//            "NameSearch" -> Prefs.currentNameSearchLociGroup = this.value
//            "Comparison" -> Prefs.currentComparisonLociGroup = this.value
//            "Options" -> Prefs.currentOptionsLociGroup = this.value
//            "Debug" -> Prefs.currentDebugLociGroup = this.value

                else -> {
                    Prefs.currentGfeSearchLociGroup = this.value
                }
            }

            gfeSearchLociStateContext.setState(this.value)
//            gfeSearchLociStateContext.updateVersions()

        }
    }

    override val root = hbox {
        add(comboBoxLoci)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    private fun swapSearchBoxes(loci: Loci) {
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(loci)
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes)
    }
}
