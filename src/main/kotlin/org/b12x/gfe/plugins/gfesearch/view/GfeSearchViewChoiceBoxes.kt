package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewChoiceBoxes : View("GFE Search Options") {

    private val gfeSearchChoiceBoxLocus = find(GfeSearchChoiceBoxLocus::class)
    private var locusChoiceBox = gfeSearchChoiceBoxLocus.root

    private var gfeSearchChoiceBoxVersion = find(GfeSearchChoiceBoxVersion::class)
    private var versionChoiceBox = gfeSearchChoiceBoxVersion.root

    private val gfeSearchChoiceBoxLoci = GfeSearchChoiceBoxLoci("GfeSearch")
    private val lociChoiceBox = gfeSearchChoiceBoxLoci.root

    override val root = borderpane {
        left = hbox { add(lociChoiceBox) }
        center = hbox { add(versionChoiceBox) }
        right = hbox { add(locusChoiceBox) }
    }
}
