package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.utilities.preference.PrefsManager
import tornadofx.setValue
import tornadofx.toProperty
import kotlin.properties.Delegates
import kotlin.reflect.jvm.internal.impl.util.Check

object GfeLayoutData {
    var checkArray: ArrayList<CheckBox> = ArrayList()
    var textArray: ArrayList<TextField> = ArrayList()
    var checkAllBoxStatus: Boolean = false
    var locusName: String = "HLA-DRB1"

    fun resetArraysHard() {
        println("CheckArray size before reset: ${checkArray.size}")
        println("TextArray size before reset: ${textArray.size}")
        checkArray = ArrayList<CheckBox>()
        println("CheckArray size after reset: ${checkArray.size}")
        textArray = ArrayList<TextField>()
        println("TextArray size after reset: ${textArray.size}")
    }

    fun resetArraysSoft() {
        println("CheckArray size before reset: ${checkArray.size}")
        println("TextArray size before reset: ${textArray.size}")
        checkArray = ArrayList<CheckBox>()
        println("CheckArray size after reset: ${checkArray.size}")
        textArray.forEach{
            it.textProperty() by Delegates.observable(it) { _, _, new ->
                it.textProperty().set("") }
//            print("${it.text}, ")

            // ...
//            it.textProperty().set("")
        }
        textArray[0].textProperty().set("w")
        textArray.forEach{
            print("${it.text}, ")
//            it.text = ""
        }
        println("TextArray size after reset: ${textArray.size}")
    }
}
