package org.b12x.gfe.core.controller.locistate

import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class HlaState: LociState {

    override fun getIdentity(ctx: LociStateContext) = "HLA"

    override fun updateVersions(ctx: LociStateContext, comboBoxVersion: ComboBoxVersion) {
        comboBoxVersion.versionList = VersionList("HLA")
        comboBoxVersion.versions = observableListOf(comboBoxVersion.versionList.allVersionNames.sortedDescending())
        comboBoxVersion.comboBoxVersion.items = comboBoxVersion.versions
        comboBoxVersion.comboBoxVersion.value = Prefs.currentGfeSearchVersionHla
    }

    override fun updateLocus(ctx: LociStateContext) {
        TODO("Not yet implemented")
    }
}

//var test = when (whichTab) {
//    "GfeSearch" -> Prefs.currentGfeSearchLociGroup = this.value
//            "NameSearch" -> Prefs.currentNameSearchLociGroup = this.value
//            "Comparison" -> Prefs.currentComparisonLociGroup = this.value
//            "Options" -> Prefs.currentOptionsLociGroup = this.value
//            "Debug" -> Prefs.currentDebugLociGroup = this.value
//    else -> {
//        Prefs.currentGfeSearchLociGroup = this.value
//    }
//}