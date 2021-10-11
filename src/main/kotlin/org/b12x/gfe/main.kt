package org.b12x.gfe

import org.b12x.gfe.core.controller.LocalVersions
import tornadofx.launch


fun main() {
    launch<GSG>()

//    val localData = LocalVersions("HLA")
//    println(localData.locusName("neo4j_HLA-DRB1_3.34.0_Download"))

//    val dataDownload = DataDownload("versionData", VersionData.DB_VERSIONS)
//    dataDownload.makeRequest("")
//    val versions = dataDownload.makeRequest("","")
//    print("Available versions: $versions")

//    val localData = ReadLocalData("HLA")
//    localData.getSubFolderNames()
}


