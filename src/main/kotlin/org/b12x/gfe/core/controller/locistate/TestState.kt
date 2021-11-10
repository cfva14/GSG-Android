package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion

class TestState: LociState {

    override var tab = "GFE"

    override fun getIdentity(ctx: LociStateContext) = "TEST"

    override fun updateVersions(ctx: LociStateContext, comboBoxVersion: ComboBoxVersion) {
        TODO("Not yet implemented")
    }

    override fun updateLocus(ctx: LociStateContext, comboBoxLocus: ComboBoxLocus) {
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