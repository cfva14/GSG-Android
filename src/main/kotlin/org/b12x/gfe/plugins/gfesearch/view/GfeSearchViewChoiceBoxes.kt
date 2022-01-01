package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewChoiceBoxes : View("GFE Search Options") {

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
}
