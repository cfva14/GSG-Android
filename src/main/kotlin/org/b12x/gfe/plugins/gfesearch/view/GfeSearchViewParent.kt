package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.layout.BorderPane
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

//    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")

//    private val locusComboBox = GfeSearchComboBoxLocus()
//    var gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
//    var versionComboBox = gfeSearchComboBoxVersion.root
//    private val lociComboBox = GfeSearchComboBoxLoci("GfeSearch")
    var gfeSearchBoxes = GfeSearchViewSearchBoxesHla(HlaLoci.A)
    var gfeSearchViewComboBoxes = GfeSearchViewComboBoxes()
    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    fun startingSearchBoxes() {
        // put in a blank box and run switch? Will it do it without it?

    }

//    val comboBoxLayoutPane: BorderPane = // borderpane() {
//        left = hbox { add(lociComboBox.root) }
//        center = hbox { add(versionComboBox) }
//        right = hbox { add(locusComboBox.root) }
//    }

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
//            val gfeSearchViewParent = find(GfeSearchViewParent::class)
            gfeSearchViewParent.gfeSearchBoxes.removeFromParent()

            comboBoxes.gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
            val versionComboBox = comboBoxes.gfeSearchComboBoxVersion.root

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