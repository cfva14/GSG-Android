package org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch

import org.b12x.gfe.core.controller.loci.LociEnum
//import org.b12x.gfe.core.view.ChoiceBoxLocus
import org.b12x.gfe.core.view.ComboBoxLocus
import org.b12x.gfe.plugins.gfesearch.view.searchboxes.GfeSearchViewSearchBoxes
import tornadofx.View

class LociStateContextGfeSearch {
    private var currentState: LociStateGfeSearch? = null

    init {
        currentState = when (PrefsGfeSearch.currentGfeSearchLociGroup) {
            "HLA" -> HlaStateGfeSearch()
            "KIR" -> KirStateGfeSearch()
            else -> {
                HlaStateGfeSearch()
            }
        }
    }

    fun setState(loci: String) {
        currentState = when (loci) {
            "HLA" -> HlaStateGfeSearch()
            "KIR" -> KirStateGfeSearch()
            else -> {
                HlaStateGfeSearch()
            }
        }
    }

    /* Loci */

    fun getLoci(): String {
        return currentState?.getLoci(this)
            ?: HlaStateGfeSearch().getLoci(this)
    }

    /* Version */

    fun getCurrentVersion(): String {
        return currentState?.getCurrentVersion(this)
            ?: HlaStateGfeSearch().getCurrentVersion(this)
    }

    fun setCurrentVersion(currentVersion: String) {
        return currentState?.setCurrentVersion(this, currentVersion)
            ?: HlaStateGfeSearch().setCurrentVersion(this, currentVersion)
    }

    fun updateVersions() {
        return currentState?.updateVersions(this)
            ?: HlaStateGfeSearch().updateVersions(this)
    }

    /* Locus */

    fun getCurrentLocus(): LociEnum {
        return currentState?.getCurrentLocus(this)
            ?: HlaStateGfeSearch().getCurrentLocus(this)
    }

    fun setCurrentLocus(currentLocus: String) {
        return currentState?.setCurrentLocus(this, currentLocus)
            ?: HlaStateGfeSearch().setCurrentLocus(this, currentLocus)
    }

    fun updateLocus() {
        return currentState?.updateLocuses(this)
            ?: HlaStateGfeSearch().updateLocuses(this)
    }

    fun getCurrentLocusNamesList(): List<String> {
        return currentState?.getCurrentLocusNamesList(this)
            ?: HlaStateGfeSearch().getCurrentLocusNamesList(this)
    }

    fun createNewSearchBoxes(): View {
        return currentState?.createNewSearchBoxes(this)
            ?: HlaStateGfeSearch().createNewSearchBoxes(this)
    }

}
