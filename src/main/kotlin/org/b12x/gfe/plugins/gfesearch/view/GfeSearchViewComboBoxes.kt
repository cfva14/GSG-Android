package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewComboBoxes : View("My View") {
    val gfeSearchComboBoxLocus = GfeSearchComboBoxLocus()
    var locusComboBox = gfeSearchComboBoxLocus.root

    var gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
    var versionComboBox = gfeSearchComboBoxVersion.root

    private val lociComboBox = GfeSearchComboBoxLoci("GfeSearch")

    override val root = borderpane {
        left = hbox { add(lociComboBox.root) }
        center = hbox { add(versionComboBox) }
        right = hbox { add(locusComboBox) }
    }
}
