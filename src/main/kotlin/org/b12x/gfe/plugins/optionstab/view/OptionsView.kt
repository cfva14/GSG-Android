package org.b12x.gfe.plugins.optionstab.view

import org.b12x.gfe.GSG
import org.b12x.gfe.core.controller.PrefsCore
import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.parsers.ParserVersionData
import tornadofx.*
import java.util.prefs.Preferences

class OptionsView : View("My View") {
//    val DataDownload()

    override val root = vbox {
        button ("Reset Preferences"){
            action {
                PrefsCore.nuclearOption()
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
