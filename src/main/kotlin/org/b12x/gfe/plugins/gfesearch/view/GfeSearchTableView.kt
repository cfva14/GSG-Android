package org.b12x.gfe.plugins.gfesearch.view

import tornadofx.*

class GfeSearchTableView(dataFormat: String): View() {

    val data = listOf(
        GfeSearchResult("HLA-A*01:01:01:01", "HLA-Aw2-1-1-1-1-1-1-1-1-1-1-1-1-1-1-1-4"),
        GfeSearchResult("HLA-A*01:01:01:02N", "HLA-Aw3-1-1-1-2-1-1-1-1-1-1-1-1-1-1-1-3"),
        GfeSearchResult("HLA-A*01:01:01:03", "HLA-Aw2-1-2-1-1-1-1-1-1-1-1-1-1-1-1-1-4")
    ).asObservable()

    var testname = data[0].gfeName.split("-")

    override val root = hbox {
        tableview(data) {
            readonlyColumn("Name", GfeSearchResult::name)
            readonlyColumn("GFE", GfeSearchResult::gfeName)
        }
        add(prettyTableView)
    }

    var prettyTableView = tableview(data) {
        for (i in 0 until data[0].gfeName.split(",").size) {

        }
    }
}

data class GfeSearchResult(val name: String, val gfeName: String)