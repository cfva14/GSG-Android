package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion

interface LociState {
    var tab: String
    fun getIdentity(ctx: LociStateContext): String
    fun updateVersions(ctx: LociStateContext, comboBoxVersion: ComboBoxVersion)
    fun updateLocus(ctx: LociStateContext, comboBoxLocus: ComboBoxLocus)
}

/*
interface CalculatorState {
    fun add(ctx: Calculator, int1: Int, int2: Int): Int
    fun multiply(ctx: Calculator, int1: Int, int2: Int): Int
}
 */