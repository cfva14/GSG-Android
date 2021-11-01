package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.utilities.preference.Prefs

class LociStateContext {
    private var currentState: LociState? = null

    init {
        currentState = when (Prefs.currentGfeSearchLociGroup) {
            "HLA" -> HlaState()
            "KIR" -> KirState()
            "TEST" -> TestState()
            else -> {
                HlaState()
            }
        }
    }

    fun setState(loci: String) {
        currentState = when (loci) {
            "HLA" -> HlaState()
            "KIR" -> KirState()
            "TEST" -> TestState()
            else -> {
                HlaState()
            }
        }
        println("Current State: ${currentState.toString()}")
    }

    fun updateVersions(comboBoxVersion: ComboBoxVersion) {
        return currentState!!.updateVersions(this, comboBoxVersion)
    }

    fun updateLocus() {
        return currentState!!.updateLocus(this)
    }

    fun getIdentity(): String {
        return currentState!!.getIdentity(this)
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