package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.utilities.getLocusType
//import org.b12x.gfe.utilities.LociLocations.setLociType
import org.b12x.gfe.utilities.setLociType
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.property

class GfeSearchLayoutData {

    companion object {
        var checkList: MutableList<CheckBox> = ArrayList()
        var textList: MutableList<TextField> = ArrayList()
        var selectedLociGroup by property(SimpleStringProperty(Prefs.currentGfeSearchLociGroup))
        var selectedLocus = getLocusType(selectedLociGroup.toString()) // HlaLoci.values().find { it.fullName == Prefs.currentGfeSearchLocusHla } ?: AllLoci.HlaLoci.A
        var selectedVersion = Prefs.currentGfeSearchVersion

        fun resetArraysHard() {
            checkList = ArrayList()
            textList = ArrayList()
        }

        fun resetArraysSoft() {
            checkList.forEach { it.isSelected = false }
            textList.forEach { it.textProperty().value = "" }
            textList[0].textProperty().value = "w"
        }
    }
}
