package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.layout.BorderPane
import kotlinx.coroutines.runBlocking
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

    private val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    var gfeSearchViewChoiceBoxes = GfeSearchViewChoiceBoxes()

    var gfeSearchBoxes = stateContext.createNewSearchBoxes()

    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = hbox {
            add(gfeSearchViewChoiceBoxes.root)
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
        val ChoiceBoxes = find(GfeSearchViewChoiceBoxes::class)


        fun swapVersionChoiceBox() {
            gfeSearchViewParent.gfeSearchViewChoiceBoxes.removeFromParent()

//            var gfeSearchChoiceBoxVersion = GfeSearchChoiceBoxVersion()
//            ChoiceBoxes.gfeSearchChoiceBoxVersion = GfeSearchChoiceBoxVersion()
//            val versionChoiceBox = gfeSearchChoiceBoxVersion.root
//            val versionChoiceBox = ChoiceBoxes.gfeSearchChoiceBoxVersion.root

//            var versionChoiceBox = gfeSearchChoiceBoxVersion.root

//            gfeSearchViewParent.versionChoiceBox.removeFromParent()
//            gfeSearchViewParent.ChoiceBoxLayoutPane.center.add(versionChoiceBox)
//            var companionVersionChoiceBox = companionGfeSearchChoiceBoxVersion.root
//            companionGfeSearchChoiceBoxVersion.root.add(companionVersionChoiceBox)

//            gfeSearchViewParent.gfeSearchBoxes.removeFromParent()
//            gfeSearchViewParent.root.top.add(gfeSearchViewParent.ChoiceBoxLayoutPane)
//            gfeSearchViewParent.root.top.add(versionChoiceBox)
//            gfeSearchViewParent.root.top.add(gfeSearchViewParent.ChoiceBoxLayoutPane)
        }

        fun swapLocusChoiceBox() {
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla.removeFromParent()
//        find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla = GfeSearchViewSearchBoxesHla(loci)
//        find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesHla)
        }
    }
}