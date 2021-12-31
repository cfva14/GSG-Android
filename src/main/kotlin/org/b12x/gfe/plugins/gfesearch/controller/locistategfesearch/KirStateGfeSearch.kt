package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import org.b12x.gfe.core.controller.loci.KirLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
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

    override fun getCurrentLocusNamesList(ctx: LociStateContextGfeSearch): List<String> {
        val locusNames = ArrayList<String>()
        KirLoci.values().forEach {
            locusNames.add(it.toString())
        }
        return locusNames
    }

    override fun getCurrentLocus(ctx: LociStateContextGfeSearch) =
        KirLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusKir } ?: KirLoci.KIR2DL1

    override fun setCurrentLocus(ctx: LociStateContextGfeSearch, newLocus: String) {
        PrefsGfeSearch.currentGfeSearchLocusKir = newLocus
    }

    override fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum) {
        // swaps the old set of search boxes out, and puts in the new set
        // based on the locus HlaLoci passed to it.

//            find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir
//                .removeFromParent()
//            find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir = GfeSearchViewSearchBoxesKir(loci)
//            find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir)

    }

    override fun createNewSearchBoxes(ctx: LociStateContextGfeSearch): View {
        val currentLocus = KirLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusKir } ?: KirLoci.KIR2DL1
        return GfeSearchViewSearchBoxesKir(currentLocus)
    }
}
