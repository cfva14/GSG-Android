package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchViewParent : View("GFE SEARCH") {

    private val stateContext = GfeSearchLayoutData.lociStateContextGfeSearch

    private var gfeSearchViewChoiceBoxes = GfeSearchViewChoiceBoxes()

    var gfeSearchBoxes = stateContext.createNewSearchBoxes()

    private val gfeSearchViewBottomHalf = GfeSearchViewBottomHalf()

    override val root = borderpane {
        top = hbox {
            add(gfeSearchViewChoiceBoxes.root)
        }

        center = vbox {
            add(gfeSearchBoxes.root)
        }

        bottom = gfeSearchViewBottomHalf.root

        style {
            padding = box(25.px)
        }
    }
}