package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.utilities.locus.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs

class GfeLayoutData {

    companion object {
        var checkList: MutableList<CheckBox> = ArrayList()
        var textList: MutableList<TextField> = ArrayList()
//        var selectedLocus = HlaLoci.A
        var selectedLocus = HlaLoci.values().find { it.fullName == Prefs.currentGfeSearchLocus }

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
