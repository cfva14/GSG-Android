package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField

data class GfeLayoutData(var checkArray: ArrayList<CheckBox> = ArrayList(),
                         var textArray: ArrayList<TextField> = ArrayList(),
                         var checkAllBoxStatus: Boolean = false,
                         var locusName: String = "HLA-DRB1") {
    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: GfeLayoutData? = null

        @JvmStatic
        @JvmOverloads
        fun getInstance(): GfeLayoutData = INSTANCE ?: synchronized(this) {
            INSTANCE ?: GfeLayoutData().also { INSTANCE = it }
        }
    }
}
