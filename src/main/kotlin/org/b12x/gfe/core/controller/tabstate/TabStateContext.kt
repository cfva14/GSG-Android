package org.b12x.gfe.core.controller.tabstate

import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.HlaStateGfeSearch

class TabStateContext {
    private var currentState: TabState? = null

    init {
        currentState = when ("GFE") { //Prefs.currentTab) {
            "GFE" -> GfeSearchState()
            "NAME" -> NameSearchState()
            "COMP" -> ComparisonState()
            else -> {
                GfeSearchState()
            }
        }
    }

    fun setState(tab: String) {
        currentState = when (tab) {
            "GFE" -> GfeSearchState()
            "NAME" -> NameSearchState()
            "COMP" -> ComparisonState()
            else -> {
                GfeSearchState()
            }
        }
        println("Current Tab State: ${currentState.toString()}")
    }

    /* Which tab */
    fun getTab(): String {
        return currentState?.getTab(this)
            ?: GfeSearchState().getTab(this)
    }

    /* Version */
    fun getCurrentVersion() =
        currentState?.getCurrentVersion(this)
            ?: GfeSearchState().getCurrentVersion(this)
}