package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import org.b12x.gfe.core.controller.loci.HlaLoci
import org.b12x.gfe.core.controller.loci.KirLoci
import org.b12x.gfe.core.controller.loci.LociEnum
import org.b12x.gfe.core.controller.version.VersionList
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.core.view.ComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchComboBoxVersion
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxesKir
import tornadofx.*
import kotlin.properties.Delegates

class KirStateGfeSearch: LociStateGfeSearch {

    override fun getLoci(ctx: LociStateContextGfeSearch) = "KIR"

    override fun getCurrentVersion(ctx: LociStateContextGfeSearch) =
        SimpleStringProperty(PrefsGfeSearch.currentGfeSearchVersionKir)

    override fun setCurrentVersion(ctx: LociStateContextGfeSearch, newVersion: String) {
        PrefsGfeSearch.currentGfeSearchVersionKir = newVersion
    }

    override fun getCurrentLocus(ctx: LociStateContextGfeSearch) =
        KirLoci.values().find { it.fullName == PrefsGfeSearch.currentGfeSearchLocusKir } ?: KirLoci.KIR2DL1

    override fun updateVersions(ctx: LociStateContextGfeSearch, verObList: ObservableList<String>) {
//        override fun updateVersions(ctx: LociStateContextGfeSearch, comboBoxVersion: ChoiceBox<String>) {
        var versionList: VersionList = VersionList("KIR")
//        comboboxVersion.versionList = VersionList("KIR")
        var versions: ObservableList<String> = observableListOf(versionList.allVersionNames)
        println(versions)
        verObList.clear()
        verObList.addAll(versions)
        val localCBV = find(GfeSearchComboBoxVersion::class).comboBoxVersion
//        localCBV.items = versions
        localCBV.value = versions[0]
//        comboBoxVersion.value = versions[0]
//        comboBoxVersion.replaceWith(comboBoxVersion)

    }

    override fun updateLocus(ctx: LociStateContextGfeSearch, comboBoxLocus: ComboBoxLocus, loci: LociEnum) {
        // swaps the old set of search boxes out, and puts in the new set
        // based on the locus HlaLoci passed to it.

//            find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir
//                .removeFromParent()
//            find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir = GfeSearchViewSearchBoxesKir(loci)
//            find(GfeSearchViewParent::class).root.center.add(find(GfeSearchViewParent::class).gfeSearchViewSearchBoxesKir)

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