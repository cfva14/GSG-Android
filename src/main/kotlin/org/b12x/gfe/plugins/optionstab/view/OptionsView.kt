package org.b12x.gfe.plugins.optionstab.view

import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.ParserVersionData
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
                val hlaDataDownload = DataDownload("HLA")
                hlaDataDownload.makeRequest(dataType = "version", dataUrl = ParserVersionData.DB_VERSIONS)
            }
        }
    }
}
