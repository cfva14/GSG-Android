package org.b12x.gfe.core.view

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import org.b12x.gfe.plugins.gfesearch.controller.HlaLoci
import org.b12x.gfe.plugins.gfesearch.view.GfeLayoutData
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*
import java.util.*
import kotlin.collections.ArrayList

class LocusComboBox : View("My View") {

    //    private val lociOptions = FXCollections.observableArrayList("HLA", "KIR")
    val prefs = Prefs()
    val currentLayoutData = GfeLayoutData.getInstance()
    private var lociNames = ArrayList<String>()
    private val lociRaw = HlaLoci.values().forEach { lociNames.add(it.toString()) }

//    private val currentLocusProperty = SimpleStringProperty()
    val currentLocus = SimpleStringProperty()
//    var currentLocus by currentLocusProperty
//    currentLocus = "HLA-A"

    var foo by property(prefs.currentLocus)
    fun fooProperty() = getProperty(LocusComboBox::foo)
//    fun fooProperty() = getProperty(LocusComboBox::foo)

//    var foo by property("baz")
//    fun fooProperty() = getProperty(Bar::foo)

    override val root = vbox {
        choicebox<String>(fooProperty(), lociNames) {
            action {
                currentLayoutData.locusName = this.value as String
            }
        }
    }
}
