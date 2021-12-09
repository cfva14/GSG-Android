package org.b12x.gfe.core.controller.tabstate

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
}