package org.b12x.gfe.plugins.gfesearch.controller
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import tornadofx.checkbox
import tornadofx.textfield

data class GfeData (var checkArray: ArrayList<CheckBox>,
                    var textArray: ArrayList<TextField>,
                    var regex: String,
                    var textFormat: String,
                    val writeToFile: Boolean){ }