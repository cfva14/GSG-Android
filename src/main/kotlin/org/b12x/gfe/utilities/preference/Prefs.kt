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

    var currentGfeSearchVersion: String by Delegates.observable(
        prefs.get(
            "currentGfeSearchVersion",
            "--"
        )
    ) { _, _, new ->
        prefs.put("currentGfeSearchVersion", new)
    }


}