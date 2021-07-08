package org.b12x.gfe.plugins.gfesearch.view

import javafx.scene.control.CheckBox
import javafx.scene.control.TextField

data class GfeLayoutData(var checkArray: ArrayList<CheckBox> = ArrayList(),
                         var textArray: ArrayList<TextField> = ArrayList(),
                         var checkAllBox: CheckBox = CheckBox(),
                         val locusName: String = "HLA-A") {
    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: GfeLayoutData? = null

        @JvmStatic
        @JvmOverloads
        fun getInstance(checkAllBox: CheckBox): GfeLayoutData = INSTANCE ?: synchronized(this) {
            INSTANCE ?: GfeLayoutData(checkAllBox = CheckBox()).also { INSTANCE = it }
        }
    }
}
