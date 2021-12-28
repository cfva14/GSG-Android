package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.KirLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesHla
import tornadofx.*


class HlaStateGfeSearch : LociStateGfeSearch {

    /* Loci */
    override fun getLoci(ctx: LociStateContextGfeSearch) = "HLA"

    /* Version */
    override fun getCurrentVersion(ctx: LociStateContextGfeSearch) =
        PrefsGfeSearch.currentGfeSearchVersionHla

    override fun setCurrentVersion(ctx: LociStateContextGfeSearch, newVersion: String) {
        PrefsGfeSearch.currentGfeSearchVersionHla = newVersion
    }

    override fun updateVersions(ctx: LociStateContextGfeSearch) {
        var versionList = VersionList("HLA")
        var versions = versionList.allVersionNames

        val gfeSearchComboBoxVersion = GfeSearchComboBoxVersion()
        val verObList1 = gfeSearchComboBoxVersion.versionsObservableList
        verObList1.clear()
        verObList1.addAll(versions)
    }

    /* Locus */
    override fun getCurrentLocus(ctx: LociStateContextGfeSearch)
        = HlaLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusHla } ?: HlaLoci.A

    override fun setCurrentLocus(ctx: LociStateContextGfeSearch, newLocus: String) {
        PrefsGfeSearch.currentGfeSearchLocusHla = newLocus
    }

    override fun getCurrentLocusNamesList(ctx: LociStateContextGfeSearch): List<String> {
        val locusNames = ArrayList<String>()
        HlaLoci.values().forEach {
            locusNames.add(it.toString())
        }
        return locusNames
    }

    override fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum) {
//        TODO("Not yet implemented")
    }

    override fun createNewSearchBoxes(ctx: LociStateContextGfeSearch): View {
        val currentLocus = HlaLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusHla } ?: HlaLoci.A

        return GfeSearchViewSearchBoxesHla(currentLocus)
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