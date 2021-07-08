package org.b12x.gfe.plugins.gfesearch.controller

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField

data class GfeData (var checkArray: ArrayList<CheckBox> = ArrayList(),
                    var textArray: ArrayList<TextField> = ArrayList(),
                    var regex: String = "",
                    var textFormat: String = "CSV",
                    val writeToFile: Boolean = false)