package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.layout.BorderPane
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

    private val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    var gfeSearchViewComboBoxes = GfeSearchViewComboBoxes()

    var gfeSearchBoxes = stateContext.createNewSearchBoxes()

    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = hbox {
            add(gfeSearchViewComboBoxes.root)
        }

        center = vbox {
            add(gfeSearchBoxes.root)
        }

        bottom = gfeSearchViewBottomHalf.root

        style {
            padding = box(25.px)
        }
    }


    companion object {
        private val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch
        val gfeSearchViewParent = find(GfeSearchViewParent::class)
        val comboBoxes = find(GfeSearchViewComboBoxes::class)


        fun swapVersionComboBox() {
            gfeSearchViewParent.gfeSearchViewComboBoxes.removeFromParent()

            var gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
//            comboBoxes.gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
            val versionComboBox = gfeSearchComboBoxVersion.root
//            val versionComboBox = comboBoxes.gfeSearchComboBoxVersion.root

//            var versionComboBox = gfeSearchComboBoxVersion.root

//            gfeSearchViewParent.versionComboBox.removeFromParent()
//            gfeSearchViewParent.comboBoxLayoutPane.center.add(versionComboBox)
//            var companionVersionComboBox = companionGfeSearchComboBoxVersion.root
//            companionGfeSearchComboBoxVersion.root.add(companionVersionComboBox)

//            gfeSearchViewParent.gfeSearchBoxes.removeFromParent()
//            gfeSearchViewParent.root.top.add(gfeSearchViewParent.comboBoxLayoutPane)
            gfeSearchViewParent.root.top.add(versionComboBox)
//            gfeSearchViewParent.root.top.add(gfeSearchViewParent.comboBoxLayoutPane)
        }

        fun swapLocusComboBox() {
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla.removeFromParent()
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla = GfeSearchViewSearchBoxesHla(loci)
//        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla)
        }
    }
}