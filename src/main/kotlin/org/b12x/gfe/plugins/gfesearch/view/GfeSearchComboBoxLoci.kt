package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import org.b12x.gfe.core.controller.locistate.LociStateContext
import org.b12x.gfe.core.view.ComboBoxLoci
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewSearchBoxes
import org.b12x.gfe.utilities.Loci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class GfeSearchComboBoxLoci(whichTab: String) : View("Available Loci"), ComboBoxLoci {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR", "TEST")
    var gfeSearchLociStateContext = GfeSearchLayoutData.gfeSearchLociStateContext

    override var currentLoci: SimpleStringProperty by property(GfeSearchLayoutData.selectedLociGroup)

    override val comboBoxLoci = choicebox<String>(currentLoci, loci) {
        action {
            Prefs.currentGfeSearchLociGroup = this.value
            gfeSearchLociStateContext.setState(this.value)
            gfeSearchLociStateContext.updateVersions(find(GfeSearchComboBoxVersion::class))

        }
    }

    override val root = hbox {
        add(comboBoxLoci)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    override fun swapSearchBoxes(loci: Loci) {
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes.removeFromParent()
        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes = GfeSearchViewSearchBoxes(loci)
        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxes)
    }
}
