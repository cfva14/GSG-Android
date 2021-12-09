package org.b12x.gfe.plugins.gfesearch.view.searchboxes
import javafx.geometry.Pos
import org.b12x.gfe.plugins.gfesearch.view.GfeSearchLayoutData
import tornadofx.*

class GfeSearchBoxShared() : View(){
    val selectAllCheckBox = checkbox {
        style { padding = box(10.px, 10.px, 0.px, 10.px) }
        action {
            if (isSelected) {
                GfeSearchLayoutData.checkList.forEach { it.isSelected = true }
            } else {
                GfeSearchLayoutData.checkList.forEach { it.isSelected = false }
            }
        }
    }

    override val root = vbox {
        val selectAllBox = vbox {
            style {
                prefWidth = 80.px
                alignment = Pos.CENTER
            }
        }
        selectAllBox.add(selectAllCheckBox)
        selectAllBox.add(label(GfeSearchLayoutData.selectedLocus.toString()) {
            style {
                padding = box(15.px, 0.px)
                fontSize = 15.px
            }
        })
    }
}