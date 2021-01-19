package org.b12x.gfe.view

import org.b12x.gfe.view.gfeSearch.GfeSearchView
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val gfeSearchView = find(GfeSearchView::class)

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
        tab("Help") {
            vbox() {
                button("Button 1")
                button("Button 2")
            }
        }
    }
}
