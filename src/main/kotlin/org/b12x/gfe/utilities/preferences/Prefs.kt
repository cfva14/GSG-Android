package org.b12x.gfe.utilities.preferences

import org.b12x.gfe.utilities.preference.PrefsManager
import kotlin.properties.Delegates

class Prefs {

    private val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()

    // String extensions
    fun String.camelToSnakeCase(): String {
        return camelRegex.replace(this) {
            "_${it.value}"
        }.toUpperCase()
    }

    // testing variables
    var testingInt: Int by Delegates.observable(PrefsManager.getPrefInt(::testingInt.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefInt(::testingInt.name.camelToSnakeCase(), new)
    }

    var currentTab: Int by Delegates.observable(PrefsManager.getPrefInt(::currentTab.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefInt(::currentTab.name.camelToSnakeCase(), new)
//        println("currentTab: $old -> $new")
    }

    var currentGfeLoci: Int by Delegates.observable(PrefsManager.getCurrentGfeLoci()) { _, old, new ->
//        println("$old -> $new")
    }
}