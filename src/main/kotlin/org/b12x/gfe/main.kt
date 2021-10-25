package org.b12x.gfe

import org.b12x.gfe.core.controller.LocalVersions
import org.b12x.gfe.utilities.setLociLocation
import tornadofx.launch
import java.io.File


fun main() {
    launch<GSG>()

    val notEmptyFolder = File("/Users/EatonK/Documents/GSG/GSGData/HLA/2.0.0/")
    val emptyFolder = File("/Users/EatonK/Documents/GSG/GSGData/HLA/2.0.1/")
    println(notEmptyFolder.list().size)//.list().toString())
    println(notEmptyFolder.list().isNotEmpty())//.list().toString())

    println(emptyFolder.list().size)
    println(emptyFolder.list().isNotEmpty())//.list().toString())

//    val localData = LocalVersions("HLA")
//    println(localData.locusName("neo4j_HLA-DRB1_3.34.0_Download"))
//    println(LocalVersions("HLA").gsgDataLocation)

//    val dataDownload = DataDownload("versionData", VersionData.DB_VERSIONS)
//    dataDownload.makeRequest("")
//    val versions = dataDownload.makeRequest("","")
//    print("Available versions: $versions")

//    val localData = ReadLocalData("HLA")
//    localData.getSubFolderNames()
}


