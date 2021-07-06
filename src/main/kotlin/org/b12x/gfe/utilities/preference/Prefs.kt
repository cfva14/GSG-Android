package org.b12x.gfe.utilities.preference

import kotlin.properties.Delegates

/**
 * The preferences for the GSG app.
 *
 * Accesses the setters and getters for each preference.
 */
class Prefs {

    private val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()

    private fun String.camelToSnakeCase(): String {
        return camelRegex.replace(this) {
            "_${it.value}"
        }.toUpperCase()
    }

    //  preferences
    var currentTab: Int by Delegates.observable(PrefsManager.getPrefInt(::currentTab.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefInt(::currentTab.name.camelToSnakeCase(), new)
    }

    // testing variables
    var testingInt: Int by Delegates.observable(PrefsManager.getPrefInt(::testingInt.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefInt(::testingInt.name.camelToSnakeCase(), new)
    }

    var testingString: String by Delegates.observable(PrefsManager.getPrefString(::testingString.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefString(::testingString.name.camelToSnakeCase(), new)
    }

    var testingBoolean: Boolean by Delegates.observable(PrefsManager.getPrefBoolean(::testingBoolean.name.camelToSnakeCase())) { _, old, new ->
        PrefsManager.setPrefBoolean(::testingString.name.camelToSnakeCase(), new)
    }
}