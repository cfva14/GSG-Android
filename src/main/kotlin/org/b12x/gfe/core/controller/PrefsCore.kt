package org.b12x.gfe.core.controller

import org.b12x.gfe.GSG
import java.util.prefs.Preferences

object PrefsCore {
    val prefs: Preferences = Preferences.userNodeForPackage(GSG::class.java)

    fun nuclearOption() {
        prefs.removeNode()
    }
}