package org.b12x.gfe.core.view

import javafx.scene.control.TabPane
import org.b12x.gfe.core.controller.tabstate.TabStateContext
import org.b12x.gfe.core.view.debugtab.DebugView
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.plugins.optionstab.view.OptionsView
import tornadofx.*

class MainView : View("GFE Search Generator") {

    private val gfeSearchViewParent = find(GfeSearchViewParent::class)
    private val optionsView = find(OptionsView::class)
    private val debugView = find(DebugView::class)
    private val tabStateContext = TabStateContext()

    override val root = tabpane {

        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
//        label(title) {
//            addClass(Styles.heading)
//        }
        tab("GFE Search") {
            add(gfeSearchViewParent)
            this.setOnSelectionChanged { _ ->
                tabStateContext.setState("GFE")
                // set which tab in parent prefs?
                println(
                    if (this.isSelected) "GfeSearch selected" else "GfeSearch unselected"
                )
            }
        }
        tab("Allele Name Search") {
//            add(alleleSearchView::class)
            this.setOnSelectionChanged { _ ->
                tabStateContext.setState("NAME")
                println(
                    if (this.isSelected) "NameSearch selected" else "NameSearch unselected"
                )
            }
        }
        tab("Comparison Tool") {
//            add(comparisonView::class)
            this.setOnSelectionChanged { _ ->
                tabStateContext.setState("COMP")
                println(
                    if (this.isSelected) "Comparison selected" else "Comparison unselected"
                )
            }
        }
        tab("Allele Calling Tool") {
//            add(alleleCallView::class)
            this.setOnSelectionChanged { _ ->
                tabStateContext.setState("ACT")
                println(
                    if (this.isSelected) "Allele Calling Tool selected" else "Allele Calling Tool unselected"
                )
            }
        }
        tab("Options") {
            add(optionsView::class)
            this.setOnSelectionChanged { _ ->
                tabStateContext.setState("OPTIONS")
                println(
                    if (this.isSelected) "Options selected" else "Options unselected"
                )
            }
        }
        tab("Help") {
            vbox() {
                button("Button 1")
                button("Button 2")
            }
        }
        tab("Information") {
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
