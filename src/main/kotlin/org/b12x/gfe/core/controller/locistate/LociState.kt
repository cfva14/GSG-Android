package org.b12x.gfe.core.controller.locistate

interface LociState {
    fun updateVersions(ctx: LociStateContext)
    fun updateLocus(ctx: LociStateContext)
    // ctx: the implemented context.

//    fun update
}

/*
interface CalculatorState {
    fun add(ctx: Calculator, int1: Int, int2: Int): Int
    fun multiply(ctx: Calculator, int1: Int, int2: Int): Int
}
 */