package org.b12x.gfe.core.view

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.ChoiceBox

interface ComboBoxLocus {

    var locusNames : List<String>
    var currentLocus: SimpleStringProperty
    var choiceBoxLocus : ChoiceBox<String>
}