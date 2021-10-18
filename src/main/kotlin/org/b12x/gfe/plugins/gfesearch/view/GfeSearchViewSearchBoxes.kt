package org.b12x.gfe.plugins.gfesearch.view

import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.b12x.gfe.utilities.loci.HlaLoci
import tornadofx.*

class GfeSearchViewSearchBoxes(loci: HlaLoci) : View("Gfe Search Boxes") {

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

    val numberOfSearchBoxes = loci.exons

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
        selectAllBox.add(label(GfeSearchLayoutData.selectedLocus.toString()) {
            style {
                padding = box(15.px, 0.px)
                fontSize = 15.px
            }
        })

        return selectAllBox
    }

    private fun individualSearchBoxAssembler(labelName: String): VBox {
        var currentCheckBox: CheckBox by singleAssign()
        var currentTextField: TextField by singleAssign()

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
            currentCheckBox.selectedProperty().addListener { observable, oldValue, newValue ->
                if(!currentCheckBox.isSelected) {
                    selectAllCheckBox.isSelected = false
                }
            }

            currentTextField = textfield("") {
                style {
                    prefWidth = 40.px
                    prefHeight = 25.px
                    padding = box(0.px, 5.px, 0.px, 5.px)
                    alignment = Pos.CENTER
                }
            }
            currentTextField.textProperty()
                .addListener { observable, oldValue, newValue ->
                    println("textfield changed from $oldValue to $newValue")
                }

            if (labelName == "Workshop Status") {
                currentTextField.setText("w")
            }

            style {
                maxWidth = 60.px
                alignment = Pos.CENTER
                padding = box(0.px, 5.px, 0.px, 5.px)
            }
        }
        searchBoxComponent.add(Group(rotatedLabel))

        GfeSearchLayoutData.checkList.add(currentCheckBox)
        GfeSearchLayoutData.textList.add(currentTextField)

        return searchBoxComponent
    }
}
