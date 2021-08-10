package org.b12x.gfe

import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.JsonParser
import tornadofx.launch

fun main() {
//    launch<MyApp>()

    val dataDownload = DataDownload()
//    val jsonParser = JsonParser()
//    print("{${jsonParser.parseJson(dataDownload.makeRequest("",""))}}")
    val versions = dataDownload.makeRequest("","").toString()
    print(versions)
}


