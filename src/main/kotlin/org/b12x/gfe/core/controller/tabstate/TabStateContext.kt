package org.b12x.gfe.core.controller.tabstate

import org.b12x.gfe.core.controller.locistate.HlaState
import org.b12x.gfe.core.controller.locistate.KirState
import org.b12x.gfe.core.controller.locistate.LociState
import org.b12x.gfe.core.controller.locistate.TestState
import org.b12x.gfe.utilities.preference.Prefs

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