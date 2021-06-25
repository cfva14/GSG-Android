package org.b12x.gfe.plugins.gfesearch.view

import org.b12x.gfe.plugins.gfesearch.view.SearchBox
import tornadofx.*

class TestLayout : View("My View") {
    private val testSearchBox: TestSearchBox by inject()
    val textFields = testSearchBox.textFields
    val checkBoxes = testSearchBox.checkBoxes

    override val root = hbox {
        add(testSearchBox.root)
        add(testSearchBox.set2)
        add(testSearchBox.set3)
        add(testSearchBox.set4)
        add(testSearchBox.set5)
    }
}

class TestSearchBox : View() {

    var checkBoxes = observableListOf(checkbox())
    var textFields = observableListOf(textfield())

    override val root = vbox {
        var check1 = checkbox { }
        var text1 = textfield { }

        checkBoxes.add(check1)
        textFields.add(text1)
    }

    val set2 = vbox {
        var check2 = checkbox { }
        var text2 = textfield { }

        checkBoxes.add(check2)
        textFields.add(text2)
    }

    val set3 = vbox {
        var check3 = checkbox { }
        var text3 = textfield { }

        checkBoxes.add(check3)
        textFields.add(text3)
    }

    val set4 = vbox {
        var check4 = checkbox { }
        var text4 = textfield { }

        checkBoxes.add(check4)
        textFields.add(text4)
    }

    val set5 = vbox {
        var check5 = checkbox { }
        var text5 = textfield { }

        checkBoxes.add(check5)
        textFields.add(text5)
    }
}
