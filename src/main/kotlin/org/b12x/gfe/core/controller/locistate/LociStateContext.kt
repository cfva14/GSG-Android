package org.b12x.gfe.core.controller.locistate

class LociStateContext {
    private var currentState: LociState? = null

    init {
        currentState = HlaState()
    }

    fun setState(state: LociState) {
        println("Current State: ${currentState.toString()}")
        currentState = state
    }

    fun updateVersions() {
        return currentState!!.updateVersions(this)
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