package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxes
import tornadofx.View

interface LociStateGfeSearch {
    /* Loci */
    fun getLoci(ctx: LociStateContextGfeSearch): String

    /* Version */
    fun getCurrentVersion(ctx: LociStateContextGfeSearch): String
    fun setCurrentVersion(ctx: LociStateContextGfeSearch, currentVersion: String)
    fun updateVersions(ctx: LociStateContextGfeSearch)

    /* Locus*/
    fun getCurrentLocus(ctx: LociStateContextGfeSearch): LociEnum
    fun setCurrentLocus(ctx: LociStateContextGfeSearch, currentLocus: String)
    fun getCurrentLocusNamesList(ctx: LociStateContextGfeSearch): List<String>
    fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum)
    fun createNewSearchBoxes(ctx: LociStateContextGfeSearch): View
}

/*
interface CalculatorState {
    fun add(ctx: Calculator, int1: Int, int2: Int): Int
    fun multiply(ctx: Calculator, int1: Int, int2: Int): Int
}
 */