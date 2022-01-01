package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.KirLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchChoiceBoxLocus
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchChoiceBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesKir
import tornadofx.*

class KirStateGfeSearch: LociStateGfeSearch {

    /* Loci */
    override fun getLoci(ctx: LociStateContextGfeSearch) = "KIR"

    /* Version */
    override fun getCurrentVersion(ctx: LociStateContextGfeSearch) =
        PrefsGfeSearch.currentGfeSearchVersionKir

    override fun setCurrentVersion(ctx: LociStateContextGfeSearch, newVersion: String) {
        PrefsGfeSearch.currentGfeSearchVersionKir = newVersion
    }

    override fun updateVersions(ctx: LociStateContextGfeSearch) {
        var versionList = VersionList("KIR")
        var versions = versionList.allVersionNames

        val gfeSearchComboBoxVersion = find(GfeSearchChoiceBoxVersion::class)
        val verObList1 = gfeSearchComboBoxVersion.versionsObservableList
        verObList1.clear()
        verObList1.addAll(versions)

        gfeSearchComboBoxVersion.currentVersion = PrefsGfeSearch.currentGfeSearchVersionKir
    }

    /* Locus */

    override fun getCurrentLocus(ctx: LociStateContextGfeSearch) =
        KirLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusKir } ?: KirLoci.KIR2DL1

    override fun setCurrentLocus(ctx: LociStateContextGfeSearch, newLocus: String) {
        PrefsGfeSearch.currentGfeSearchLocusKir = newLocus
    }

    fun getKirLocusNames(): List<String> {
        val locusNames = ArrayList<String>()
        KirLoci.values().forEach {
            locusNames.add(it.toString())
        }
        return locusNames
    }

    override fun getCurrentLocusNamesList(ctx: LociStateContextGfeSearch) = getKirLocusNames()

    // I know it's not spelled locuses, but loci is already used.
    override fun updateLocuses(ctx: LociStateContextGfeSearch) {
        val locusNames = getKirLocusNames()

        val gfeSearchChoiceBoxLocus = find(GfeSearchChoiceBoxLocus::class)
        val locObservableList = gfeSearchChoiceBoxLocus.locusObservableList
        locObservableList.clear()
        locObservableList.addAll(locusNames)

        gfeSearchChoiceBoxLocus.currentLocus = PrefsGfeSearch.currentGfeSearchLocusKir
    }

    override fun createNewSearchBoxes(ctx: LociStateContextGfeSearch): View {
        val currentLocus = KirLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusKir } ?: KirLoci.KIR2DL1
        return GfeSearchViewSearchBoxesKir(currentLocus)
    }
}
