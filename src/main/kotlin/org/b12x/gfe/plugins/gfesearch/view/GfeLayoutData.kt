package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.utilities.preference.PrefsManager
import tornadofx.runAsync
import tornadofx.setValue
import tornadofx.toProperty
import kotlin.properties.Delegates
import kotlin.reflect.jvm.internal.impl.util.Check

class GfeLayoutData {
//    var checkList: MutableList<CheckBox> = ArrayList()
//    var textList: MutableList<TextField> = ArrayList()
//    var checkAllBoxStatus: Boolean = false
//    var locusName: String = "HLA-DRB1"

    companion object {
        var checkList: MutableList<CheckBox> = ArrayList()
        var textList: MutableList<TextField> = ArrayList()
        var checkAllBoxStatus: Boolean = false
        var locusName: String = "HLA-DRB1"

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
