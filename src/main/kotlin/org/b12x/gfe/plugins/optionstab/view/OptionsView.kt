package org.b12x.gfe.plugins.optionstab.view

import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.VersionData
import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.*

class OptionsView : View("My View") {
//    val DataDownload()

    override val root = vbox {
        button ("Reset Preferences"){
            action {
                Prefs.nuclearOption()
            }
        }

        button ("Download current Versions"){
            action {
                val dataDownload = DataDownload("versionData", VersionData.DB_VERSIONS)
                dataDownload.makeRequest()
            }
        }
    }
}
