package org.b12x.gfe.core.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.LociEnum

//import org.b12x.gfe.utilities.Loci

interface ComboBoxLoci {
    var currentLoci: SimpleStringProperty
    val comboBoxLoci: ChoiceBox<String>
}