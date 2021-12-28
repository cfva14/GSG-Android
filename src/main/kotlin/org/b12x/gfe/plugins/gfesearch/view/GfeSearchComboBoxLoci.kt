package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLoci
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.PrefsGfeSearch
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.VersionEventBus
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchComboBoxLoci(whichTab: String) : View("Available Loci"), ComboBoxLoci {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR")
    var gfeSearchLociStateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    override var currentLoci: SimpleStringProperty by property(GfeSearchLayoutData.selectedLociGroup)

    override val comboBoxLoci = choicebox<String>(currentLoci, loci) {
        action {
            PrefsGfeSearch.currentGfeSearchLociGroup = this.value
            gfeSearchLociStateContext.setState(this.value)
//            println(find(GfeSearchComboBoxVersion::class).comboBoxVersion)
            runBlocking {
                async {
                    gfeSearchLociStateContext.updateVersions()
                    GfeSearchViewParent.swapVersionComboBox()

                }
            }


//            fire(VersionEventBus)
            gfeSearchLociStateContext.updateLocus(find(GfeSearchComboBoxLocus::class), HlaLoci.A)
        }
    }

    override val root = hbox {
        add(comboBoxLoci)
    }

    // swaps the old set of search boxes out, and puts in the new set
    // based on the locus HlaLoci passed to it.
    override fun swapSearchBoxes(loci: LociEnum) {
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla.removeFromParent()
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla = GfeSearchViewSearchBoxesHla(loci)
//        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla)
    }
}
