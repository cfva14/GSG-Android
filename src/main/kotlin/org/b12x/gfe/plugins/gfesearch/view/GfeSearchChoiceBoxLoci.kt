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

class GfeSearchChoiceBoxLoci(whichTab: String) : View("Available Loci") {

    val loci: ObservableList<String> = observableListOf("HLA", "KIR")
    var gfeSearchLociStateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    var currentLoci: SimpleStringProperty by property(GfeSearchLayoutData.selectedLociGroup)

    val choiceBoxLoci = choicebox<String>(currentLoci, loci) {
        action {
            PrefsGfeSearch.currentGfeSearchLociGroup = this.value
            gfeSearchLociStateContext.setState(this.value)
//            println(find(GfeSearchComboBoxVersion::class).comboBoxVersion)
//            runBlocking {
//                async {
                    gfeSearchLociStateContext.updateVersions()
                    find(GfeSearchViewChoiceBoxes::class).swapVersionChoiceBox()
//                    GfeSearchViewParent.swapVersionChoiceBox()
//                }
//            }

//            gfeSearchLociStateContext.updateLocus(find(GfeSearchChoiceBoxLocus::class), HlaLoci.A)
        }
    }

    override val root = hbox {
        add(choiceBoxLoci)
    }
}
