package org.b12x.gfe

import javafx.stage.Stage
import org.b12x.gfe.core.view.MainView
import tornadofx.App
import tornadofx.Stylesheet.Companion.label

class MyApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 800.0
        stage.height = 600.0

//        label("GFE Search Generator")
    }
 }