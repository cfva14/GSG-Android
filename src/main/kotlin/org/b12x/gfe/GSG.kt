package org.b12x.gfe

import javafx.stage.Stage
import org.b12x.gfe.core.view.MainView
import tornadofx.App

class GSG: App(MainView::class, Styles::class) {

    val gsgWidth = 1150.0
    val gsgHeight = 800.0

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = gsgWidth
        stage.height = gsgHeight
    }
}