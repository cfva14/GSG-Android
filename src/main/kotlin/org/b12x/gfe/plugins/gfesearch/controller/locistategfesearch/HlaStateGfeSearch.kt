package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion
import tornadofx.*
import tornadofx.FXEvent
import tornadofx.EventBus.RunOn.*



class HlaStateGfeSearch : LociStateGfeSearch {

    override fun getLoci(ctx: LociStateContextGfeSearch) = "HLA"

    override fun getCurrentVersion(ctx: LociStateContextGfeSearch) =
        SimpleStringProperty(PrefsGfeSearch.currentGfeSearchVersionHla)

    override fun setCurrentVersion(ctx: LociStateContextGfeSearch, newVersion: String) {
        PrefsGfeSearch.currentGfeSearchVersionHla = newVersion
    }

    override fun getCurrentLocus(ctx: LociStateContextGfeSearch) =
        HlaLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusHla } ?: HlaLoci.A


    override fun updateVersions(ctx: LociStateContextGfeSearch, verObList: ObservableList<String>) {
//        override fun updateVersions(ctx: LociStateContextGfeSearch, comboBoxVersion: ChoiceBox<String>) {
        var versionList: VersionList = VersionList("HLA")
//        comboBoxVersion.versionList = VersionList("HLA")
//        comboBoxVersion.versions.clear()
//        comboBoxVersion.versions.setAll(comboBoxVersion.versionList.allVersionNames)
//        comboBoxVersion.versions = observableListOf(comboBoxVersion.versionList.allVersionNames.sortedDescending())
        verObList.clear()
        verObList.addAll(observableListOf(versionList.allVersionNames))
//        comboBoxVersion.comboBoxVersion.items = (comboBoxVersion.versions)
//        verObList.value = versionList.allVersionNames[0]
//        fire(VersionEventBus)
    }

    override fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum) {
//        TODO("Not yet implemented")
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