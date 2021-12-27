package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion

class LociStateContextGfeSearch {
    private var currentState: LociStateGfeSearch? = null

    init {
        currentState = when (PrefsGfeSearch.currentGfeSearchLociGroup) {
            "HLA" -> HlaStateGfeSearch()
            "KIR" -> KirStateGfeSearch()
            else -> {
                HlaStateGfeSearch()
            }
        }
    }

    fun setState(loci: String) {
        currentState = when (loci) {
            "HLA" -> HlaStateGfeSearch()
            "KIR" -> KirStateGfeSearch()
            else -> {
                HlaStateGfeSearch()
            }
        }
        println("Current State: ${currentState.toString()}")
    }

    fun updateVersions() {
        return currentState!!.updateVersions(this)
    }

    fun updateLocus(comboBoxLocus: ComboBoxLocus, loci: LociEnum) {
        return currentState!!.updateLocus(this, comboBoxLocus, loci)
    }

    fun getLoci(): String {
        return currentState!!.getLoci(this)
    }

    fun getCurrentVersion(): String {
        return currentState!!.getCurrentVersion(this)
    }

    fun setCurrentVersion(currentVersion: String) {
        return currentState!!.setCurrentVersion(this, currentVersion)
    }

    fun getCurrentLocus(): LociEnum {
        return currentState!!.getCurrentLocus(this)
    }
}

/*
object Calculator { // StateContext

    private var currentState: CalculatorState? = null

    init {
        currentState = EnumCalc()
    }

    fun setState(state: CalculatorState) {
        println("Current state: ${state.toString()}")
        currentState = state
    }

    fun add(int1: Int, int2: Int): Int {
        println("Adding via ${currentState.toString()}")
        return currentState!!.add(this, int1, int2)
    }

    fun multiply(int1: Int, int2: Int): Int {
        println("Multiplying via ${currentState.toString()}")
        return currentState!!.multiply(this, int1, int2)
    }
}
 */