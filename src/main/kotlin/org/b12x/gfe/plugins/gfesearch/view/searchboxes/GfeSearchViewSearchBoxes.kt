package org.b12x.gfe.plugins.gfesearch.view.searchboxes

import javafx.scene.control.CheckBox
import javafx.scene.layout.HBox

interface GfeSearchViewSearchBoxes {
    val numberOfSearchBoxes: Int
    fun completedSearchBoxGenerator(numberOfBoxes: Int): HBox


}