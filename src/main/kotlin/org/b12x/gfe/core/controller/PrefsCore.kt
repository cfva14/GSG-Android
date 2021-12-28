package org.b12x.gfe.core.controller

import org.b12x.gfe.GSG
import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.PrefsGfeSearch
import java.util.prefs.Preferences

object PrefsCore {
    var prefs: Preferences = Preferences.userNodeForPackage(GSG::class.java)

    fun nuclearOption() {
        prefs.removeNode()
        prefs = Preferences.userNodeForPackage(GSG::class.java)
        PrefsGfeSearch.prefs = prefs
    }
}