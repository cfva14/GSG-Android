package org.b12x.gfe

import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.JsonData
import kotlinx.serialization.*
import kotlinx.serialization.json.Json


fun main() {
//    launch<MyApp>()

    val dataDownload = DataDownload()
//    val jsonParser = JsonParser()
//    print("{${jsonParser.parseJson(dataDownload.makeRequest("",""))}}")
//    val versions = dataDownload.makeRequest("","").toString()

//    val versions: Json = """{
//	"versions": [
//		"3.45.0",
//		"3.44.0",
//		"3.43.0"
//	]
//}"""

    val versions = dataDownload.makeRequest("","") //.toString()
//    val obj = Json.decodeFromString<JsonData>(versions)
    print("$versions")
}


