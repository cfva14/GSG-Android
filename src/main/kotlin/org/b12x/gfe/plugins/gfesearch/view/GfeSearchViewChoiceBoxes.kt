package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import tornadofx.*

class GfeSearchViewChoiceBoxes : View("GFE Search Options") {
    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    val gfeSearchChoiceBoxLocus = find(GfeSearchChoiceBoxLocus::class)
    var locusChoiceBox = gfeSearchChoiceBoxLocus.root

    var gfeSearchChoiceBoxVersion = find(GfeSearchChoiceBoxVersion::class)
    var versionChoiceBox = gfeSearchChoiceBoxVersion.root

    val gfeSearchChoiceBoxLoci = GfeSearchChoiceBoxLoci("GfeSearch")
    val lociChoiceBox = gfeSearchChoiceBoxLoci.root
    
    override val root = borderpane {
        left = hbox { add(lociChoiceBox) }
        center = hbox { add(versionChoiceBox) }
        right = hbox { add(locusChoiceBox) }
    }

//    fun swapVersionChoiceBox() {
//        println("Yes Virgina, there is a call to swap the Version Choice Box.")
////        find(GfeSearchViewChoiceBoxes::class).versionChoiceBox.removeFromParent()
////        gfeSearchChoiceBoxVersion = GfeSearchChoiceBoxVersion()
////        versionChoiceBox = gfeSearchChoiceBoxVersion.root
//        root.center.add(versionPane)
//    }
}
