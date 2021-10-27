package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.plugins.gfesearch.view.GfeSearchComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import tornadofx.*

class HlaState: LociState {

    override fun getIdentity(ctx: LociStateContext) = "HLA"

    override fun updateVersions(ctx: LociStateContext) {
        find(GfeSearchComboBoxVersion::class).versions
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