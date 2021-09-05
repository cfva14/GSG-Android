package org.b12x.gfe.plugins.optionstab.view

import org.b12x.gfe.utilities.preference.ClearPrefs
import org.b12x.gfe.utilities.preference.Prefs
import org.b12x.gfe.utilities.preference.PrefsOld
import tornadofx.*

class OptionsView : View("My View") {

    override val root = vbox {
        button ("Reset Preferences"){
            action {
                Prefs.nuclearOption()
            }
        }
    }
}
