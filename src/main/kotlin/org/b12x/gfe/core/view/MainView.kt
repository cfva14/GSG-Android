package org.b12x.gfe.core.view

import javafx.scene.control.TabPane
import org.b12x.gfe.Styles
import org.b12x.gfe.core.view.debugtab.DebugView
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchView
import org.b12x.gfe.plugins.optionstab.view.OptionsView
import tornadofx.*

class MainView : View("GFE Search Generator") {

    private val gfeSearchView = find(GfeSearchView::class)
    private val optionsView = find(OptionsView::class)
    private val debugView = find(DebugView::class)

    override val root = tabpane {

        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
//        label(title) {
//            addClass(Styles.heading)
//        }
        tab("GFE Search") {
            add(gfeSearchView::class)
        }
        tab("Allele Name Search") {
//            add(alleleSearchView::class)
        }
        tab("Allele Calling Tool") {
//            add(alleleCallView::class)
        }
        tab("Options") {
            add(optionsView::class)
        }
        tab("Help") {
            vbox() {
                button("Button 1")
                button("Button 2")
            }
        }
        tab("Debug") {
            add(debugView::class)
        }
    }
}
