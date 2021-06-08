package org.b12x.gfe

import org.b12x.gfe.utilities.preferences.Prefs
import org.b12x.gfe.utilities.preference.PrefsManager

import tornadofx.launch

fun main() {


    val prefs = Prefs()
    prefs.currentTab = 0
    println("Current tab: " + prefs.currentTab)
    println("Current GFE Loci: " + prefs.currentGfeLoci)
    prefs.currentTab = 1
    println("Current tab: " + prefs.currentTab)
    println("PrefsManager's current value for CURRENT_TAB: " + PrefsManager.getPrefInt("CURRENT_TAB"))

    launch<MyApp>()
}

