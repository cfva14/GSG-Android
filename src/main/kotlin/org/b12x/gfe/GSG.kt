package org.b12x.gfe

import javafx.stage.Stage
import org.b12x.gfe.core.view.MainView
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import tornadofx.App
import tornadofx.Stylesheet.Companion.label

class GSG: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 1150.0
        stage.height = 800.0

    }

}