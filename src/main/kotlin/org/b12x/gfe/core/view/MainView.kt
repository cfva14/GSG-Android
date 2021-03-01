package org.b12x.gfe.core.view

import org.b12x.gfe.plugins.gfesearch.view.GfeSearchView
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    private val gfeSearchView = find(GfeSearchView::class)

    override val root = tabpane {
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
//            add(optionsView::class)
        }
        tab("Help") {
            vbox() {
                button("Button 1")
                button("Button 2")
            }
        }
    }
}
