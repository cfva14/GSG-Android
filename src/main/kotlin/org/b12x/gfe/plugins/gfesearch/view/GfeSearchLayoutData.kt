package org.b12x.gfe.plugins.gfesearch.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.LociStateContextGfeSearch
//import org.b12x.gfe.utilities.getLocusType
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.PrefsGfeSearch
import tornadofx.property

class GfeSearchLayoutData {

    companion object {
        var checkList: MutableList<CheckBox> = ArrayList()
        var textList: MutableList<TextField> = ArrayList()
        var lociStateContextGfeSearch = LociStateContextGfeSearch()

//        var selectedLociGroup by property(SimpleStringProperty(lociStateContextGfeSearch.getLoci()))
//        var selectedVersion by property(SimpleStringProperty(lociStateContextGfeSearch.getCurrentVersion()))

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
