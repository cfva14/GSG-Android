package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchComboBoxVersion
import tornadofx.*
import tornadofx.FXEvent
import tornadofx.EventBus.RunOn.*



class HlaStateGfeSearch : LociStateGfeSearch {

    override fun getLoci(ctx: LociStateContextGfeSearch) = "HLA"

    override fun getCurrentVersion(ctx: LociStateContextGfeSearch) =
        PrefsGfeSearch.currentGfeSearchVersionHla

    override fun setCurrentVersion(ctx: LociStateContextGfeSearch, newVersion: String) {
        PrefsGfeSearch.currentGfeSearchVersionHla = newVersion
    }

    override fun getCurrentLocus(ctx: LociStateContextGfeSearch) =
        HlaLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusHla } ?: HlaLoci.A

    fun setCurrentLocus(ctx: LociStateContextGfeSearch, newLocus: String) {
        PrefsGfeSearch.currentGfeSearchLocusHla = newLocus
    }

    override fun updateVersions(ctx: LociStateContextGfeSearch) {
//        override fun updateVersions(ctx: LociStateContextGfeSearch, comboBoxVersion: ChoiceBox<String>) {
        var versionList: VersionList = VersionList("HLA")
        var versions = versionList.allVersionNames
        println(versions)
//        comboBoxVersion.versionList = VersionList("HLA")
//        comboBoxVersion.versions.clear()
//        comboBoxVersion.versions.setAll(comboBoxVersion.versionList.allVersionNames)
//        comboBoxVersion.versions = observableListOf(comboBoxVersion.versionList.allVersionNames.sortedDescending())
        val gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
        val verObList1 = gfeSearchComboBoxVersion.versionsObservableList
        verObList1.clear()
        verObList1.addAll(versions)
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