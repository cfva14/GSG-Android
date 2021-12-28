package org.b12x.gfe.plugins.gfesearch.view.searchboxes

import javafx.scene.control.CheckBox
import javafx.scene.layout.HBox

interface GfeSearchViewSearchBoxes {
    fun completedSearchBoxGenerator(numberOfBoxes: Int): HBox
}