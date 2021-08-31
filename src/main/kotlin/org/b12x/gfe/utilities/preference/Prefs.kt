package org.b12x.gfe.utilities.preference

import kotlin.properties.Delegates
import tornadofx.*

object Prefs {

    var currentGfeSearchLocus: String()

    preferences("GSG") {
        // GFE Search Tab
        currentGfeSearchLocus: String by Delegates.observable(get("current gfe search locus", "HLA-A")) { _, old, new ->
            putString("current gfe search locus", new)
//        PrefsManager.setPrefString(::currentLocus.name.camelToSnakeCase(), new)
        }
    }


}