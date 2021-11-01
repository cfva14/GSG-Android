package org.b12x.gfe.utilities.preference

import org.b12x.gfe.GSG
import java.util.prefs.Preferences
import kotlin.properties.Delegates

object Prefs {

    private val prefs: Preferences = Preferences.userNodeForPackage(GSG::class.java)

    fun nuclearOption() {
        prefs.removeNode()
    }

    var currentGfeSearchLociGroup: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchLociGroup",
            "HLA"
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchLociGroup", new)
    }

    var currentGfeSearchLocusHla: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchLocusHla",
            "A"
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchLocusHla", new)
    }

    var currentGfeSearchLocusKir: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchLocusKir",
            "KIR2DL1"
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchLocusKir", new)
    }

    var currentGfeSearchVersionHla: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchVersionHla",
            ""
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchVersionHla", new)
    }

    var currentGfeSearchVersionKir: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchVersionKir",
            ""
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchVersionKir", new)
    }


}