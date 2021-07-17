package org.b12x.gfe.plugins.optionstab.view

import org.b12x.gfe.utilities.preference.ClearPrefs
import org.b12x.gfe.utilities.preference.Prefs
import org.b12x.gfe.utilities.preference.PrefsManager
import tornadofx.*

class OptionsView : View("My View") {

    val prefs = Prefs()

    override val root = vbox {
        button ("Reset Preferences"){
            action {
                ClearPrefs.clearAllPrefs()
//                prefs.currentLocus = "HLA-DQA1"
            }
        }
    }
}
