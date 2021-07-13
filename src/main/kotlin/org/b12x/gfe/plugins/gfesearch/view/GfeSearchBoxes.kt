package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.TextAlignment
import tornadofx.*

class GfeSearchBoxes : View("Gfe Search Boxes") {

    val selectAllCheckBox = checkbox {
        style { padding = box(10.px, 10.px, 0.px, 10.px) }
        action {
            if (isSelected) {
                currentLayoutData.checkArray.forEach { it.isSelected = true }
            } else {
                currentLayoutData.checkArray.forEach { it.isSelected = false }
            }
        }
    }
    val currentLayoutData = GfeLayoutData.getInstance() //selectAllCheckBox)
    val numberOfSearchBoxes = 8
    // TODO - link # of search boxes to locus

    val completedSearchBox = completedSearchBoxGenerator(numberOfSearchBoxes)

    override val root = vbox {
        label {
            text = "Check all"
            style {
                padding = box(0.px, 0.px, 0.px, 10.px)
                fontSize = 13.px
            }
        }
        add(Group(completedSearchBox))
        style {
            padding = box(25.px, 0.px)
        }
    }

    private fun completedSearchBoxGenerator(numberOfBoxes: Int): HBox {
        val completedSearchBox = hbox {
            style {
                padding = box(0.px, 0.px, 0.px, 0.px)
            }
        }
        completedSearchBox.add(Group(selectAllBoxAssembler()))

        completedSearchBox.add(Group(individualSearchBoxAssembler("Workshop Status")))
        completedSearchBox.add(Group(individualSearchBoxAssembler("5' UTR")))

        for (i in 1 until numberOfBoxes) {
            completedSearchBox.add(Group(individualSearchBoxAssembler("Exon $i")))
            completedSearchBox.add(Group(individualSearchBoxAssembler("Intron $i")))
        }

        completedSearchBox.add(Group(individualSearchBoxAssembler("Exon $numberOfBoxes")))
        completedSearchBox.add(Group(individualSearchBoxAssembler("3' UTR")))

        return completedSearchBox
    }

    private fun selectAllBoxAssembler(): VBox {
        val selectAllBox = vbox {
            style {
                prefWidth = 80.px
//                padding = box(10.px, 0.px, 0.px, 0.px)
                alignment = Pos.CENTER
            }
        }
        selectAllBox.add(selectAllCheckBox)
        selectAllBox.add(label(currentLayoutData.locusName) {
            style {
                padding = box(15.px, 0.px)
                fontSize = 15.px
            }
        })

        return selectAllBox

    }

    private fun individualSearchBoxAssembler(labelName: String): VBox {
        lateinit var currentCheckBox: CheckBox
        lateinit var currentTextField: TextField

        val rotatedLabel = label(labelName) {
            style {
                rotate = 90.deg
                padding = box(0.px, 0.px, 0.px, 10.px)
                fontSize = 14.px
            }
        }

        val searchBoxComponent = vbox {
            currentCheckBox = checkbox {
                style {
                    padding = box(10.px)
                }
            }
            currentTextField = textfield {
                style {
                    prefWidth = 40.px
                    prefHeight = 25.px
                    padding = box(0.px, 5.px, 0.px, 5.px)
                    textAlignment = TextAlignment.CENTER
                }
            }

            style {
                maxWidth = 60.px
                alignment = Pos.CENTER
                padding = box(0.px, 5.px, 0.px, 5.px)
            }
        }
        searchBoxComponent.add(Group(rotatedLabel))

        currentLayoutData.checkArray.add(currentCheckBox)
        currentLayoutData.textArray.add(currentTextField)

        return searchBoxComponent
    }
}
