package org.b12x.gfe.core.view

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.plugins.gfesearch.controller.HlaLoci
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*
import java.util.*
import kotlin.collections.ArrayList

class LocusComboBox : View("My View") {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")
    val prefs = Prefs()
    private var lociNames = ArrayList<String>()
    private val lociRaw = HlaLoci.values().forEach { lociNames.add(it.toString()) }

    private val currentLocusProperty = SimpleStringProperty()
    var currentLocus by currentLocusProperty
//    currentLocus = "HLA-A"

    override val root = vbox {
        combobox<String>(null, lociNames)
    }
}
