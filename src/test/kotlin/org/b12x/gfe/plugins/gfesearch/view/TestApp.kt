package org.b12x.gfe.plugins.gfesearch.view

import io.reactivex.rxjava3.kotlin.*
import javafx.collections.FXCollections
import javafx.scene.control.CheckBox
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.b12x.gfe.Styles
import org.b12x.gfe.core.view.MainView
import tornadofx.*
import java.util.Collections.list

class TestApp: App(TestLayout::class, Styles::class) {
    val parentStage = Stage()

//    override fun onDock() {
//        runAsync {
//                Thread.sleep(100)
//            }
//        }

    override fun start(stage: Stage) {
        super.start(parentStage)
        stage.width = 400.0
        stage.height = 300.0
    }
}

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

    var textFields = ArrayList<TextField>()
    var checkBoxes = ArrayList<CheckBox>()

    override val root = vbox {
        val check1 = checkbox { }
        val text1 = textfield { }

        checkBoxes.add(check1)
        textFields.add(text1)
    }

    val set2 = vbox {
        val check2 = checkbox()
        val text2 = textfield("4")

        checkBoxes.add(check2)
        textFields.add(text2)
    }

    val set3 = vbox {
        val check3 = checkbox()
        check3.setSelected(true)
        val text3 = textfield { }

        checkBoxes.add(check3)
        textFields.add(text3)
    }

    val set4 = vbox {
        val check4 = checkbox { }
        val text4 = textfield { }

        checkBoxes.add(check4)
        textFields.add(text4)
    }

    val set5 = vbox {
        val check5 = checkbox { }
        val text5 = textfield { }

        checkBoxes.add(check5)
        textFields.add(text5)
    }
}
