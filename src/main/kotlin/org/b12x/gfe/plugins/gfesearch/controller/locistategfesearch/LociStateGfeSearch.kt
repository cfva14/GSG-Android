package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion

interface LociStateGfeSearch {
    fun getLoci(ctx: LociStateContextGfeSearch): String
    fun getCurrentVersion(ctx: LociStateContextGfeSearch): String
    fun setCurrentVersion(ctx: LociStateContextGfeSearch, currentVersion: String)
    fun getCurrentLocus(ctx: LociStateContextGfeSearch): LociEnum
    fun updateVersions(ctx: LociStateContextGfeSearch)
    fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum)
}

/*
interface CalculatorState {
    fun add(ctx: Calculator, int1: Int, int2: Int): Int
    fun multiply(ctx: Calculator, int1: Int, int2: Int): Int
}
 */