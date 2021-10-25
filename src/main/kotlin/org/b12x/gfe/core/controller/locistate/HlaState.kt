package org.b12x.gfe.core.controller.locistate

class HlaState: LociState {
    override fun updateVersions(ctx: LociStateContext) {
        TODO("Not yet implemented")
    }

    override fun updateLocus(ctx: LociStateContext) {
        TODO("Not yet implemented")
    }
}

/*
class SealedCalc: CalculatorState {

    override fun add(ctx: Calculator, int1: Int, int2: Int): Int =
        CalculatorSealed.Add(int1, int2).apply(int1, int2)

    override fun multiply(ctx: Calculator, int1: Int, int2: Int): Int =
        CalculatorSealed.Multiply(int1, int2).apply(int1, int2)
}
*/