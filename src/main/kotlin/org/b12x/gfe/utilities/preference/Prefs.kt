package org.b12x.gfe.utilities.preference

import org.b12x.gfe.GSG
import java.util.prefs.Preferences
import kotlin.properties.Delegates
import kotlin.reflect.KMutableProperty0

object Prefs {

    val prefs: Preferences = Preferences.userNodeForPackage(GSG::class.java)

    fun nuclearOption() {
        prefs.removeNode()
    }

    var currentGfeSearchLocus: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchLocus",
            "HLA-A"
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchLocus", new)
    }


}