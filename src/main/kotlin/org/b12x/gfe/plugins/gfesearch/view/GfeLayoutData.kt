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
            println("CheckArray size before reset: ${checkList.size}")
            println("TextArray size before reset: ${textList.size}")
            checkList = ArrayList()
            println("CheckArray size after reset: ${checkList.size}")
            textList = ArrayList()
            println("TextArray size after reset: ${textList.size}")
        }

        fun resetArraysSoft() {
            runAsync {

                checkList.forEach { it.isSelected = false }

//                println("TextArray size before reset: ${textList.size}")
                textList[0].textProperty().value = "w"
                for (i in 1 until textList.size) {
                    textList[i].textProperty().value = ""
                }
//                println("TextArray size after reset: ${textList.size}")

            }
        }
    }
}
