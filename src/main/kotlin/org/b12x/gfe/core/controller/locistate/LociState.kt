package org.b12x.gfe.core.controller.locistate

interface LociState {
    fun getIdentity(ctx: LociStateContext): String
    fun updateVersions(ctx: LociStateContext)
    fun updateLocus(ctx: LociStateContext)
}

/*
interface CalculatorState {
    fun add(ctx: Calculator, int1: Int, int2: Int): Int
    fun multiply(ctx: Calculator, int1: Int, int2: Int): Int
}
 */