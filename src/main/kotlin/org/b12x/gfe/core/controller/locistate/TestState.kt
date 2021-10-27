package org.b12x.gfe.core.controller.locistate

class TestState: LociState {

    override fun getIdentity(ctx: LociStateContext) = "TEST"

    override fun updateVersions(ctx: LociStateContext) {
        TODO("Not yet implemented")
    }

    override fun updateLocus(ctx: LociStateContext) {
        TODO("Not yet implemented")
    }
}

/*
class EnumCalc: CalculatorState {

    override fun add(ctx: Calculator, int1: Int, int2: Int): Int =
        CalculatorEnum.ADD.apply(int1, int2)

    override fun multiply(ctx: Calculator, int1: Int, int2: Int): Int =
        CalculatorEnum.MULTIPLY.apply(int1, int2)
}
*/