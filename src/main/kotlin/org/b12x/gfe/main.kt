package org.b12x.gfe

import org.b12x.gfe.core.model.DataDownload
import org.b12x.gfe.core.model.JsonData
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import org.b12x.gfe.core.model.parsers.VersionData
import tornadofx.launch


fun main() {
    launch<MyApp>()

//    val dataDownload = DataDownload("versionData", VersionData.DB_VERSIONS)
//    dataDownload.makeRequest("")
//    val versions = dataDownload.makeRequest("","")
//    print("Available versions: $versions")
}


