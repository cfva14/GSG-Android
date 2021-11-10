package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion
import tornadofx.observableListOf

class KirState: LociState {

    override var tab = "GFE"

    override fun getIdentity(ctx: LociStateContext) = "KIR"

    override fun updateVersions(ctx: LociStateContext, comboBoxVersion: ComboBoxVersion) {
        comboBoxVersion.versionList = VersionList("KIR")
        comboBoxVersion.versions = observableListOf(comboBoxVersion.versionList.allVersionNames.sortedDescending())
        comboBoxVersion.comboBoxVersion.items = comboBoxVersion.versions
        comboBoxVersion.comboBoxVersion.value = comboBoxVersion.versions[0]

    }

    override fun updateLocus(ctx: LociStateContext, comboBoxLocus: ComboBoxLocus) {
        // TODO("Not yet implemented")
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