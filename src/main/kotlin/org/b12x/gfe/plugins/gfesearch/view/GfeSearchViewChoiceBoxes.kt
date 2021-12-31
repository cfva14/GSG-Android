package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import tornadofx.*

class GfeSearchViewChoiceBoxes : View("GFE Search Options") {
    val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch
    val gfeSearchChoiceBoxLocus = GfeSearchChoiceBoxLocus()
    var locusChoiceBox = gfeSearchChoiceBoxLocus.root

    var gfeSearchChoiceBoxVersion = GfeSearchChoiceBoxVersion()
    var versionChoiceBox = gfeSearchChoiceBoxVersion.root
    var versionPane = hbox { add(versionChoiceBox) }

    private val lociChoiceBox = GfeSearchChoiceBoxLoci("GfeSearch")

    override val root = borderpane {
        left = hbox { add(lociChoiceBox.root) }
        center = hbox { add(versionPane) }
        right = hbox { add(locusChoiceBox) }
    }

    fun swapVersionChoiceBox() {
        println("Yes Virgina, there is a call to swap the Version Choice Box.")
        find(this::class).versionPane.removeFromParent()
//        gfeSearchChoiceBoxVersion = GfeSearchChoiceBoxVersion()
//        versionChoiceBox = gfeSearchChoiceBoxVersion.root
//        root.center.add(gfeSearchChoiceBoxVersion.root)
    }
}
