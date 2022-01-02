package org.b12x.gfe.core.controller.version

import org.b12x.gfe.core.model.parsers.ParserVersionData
import org.b12x.gfe.utilities.DirectoryManagement
import org.b12x.gfe.utilities.FileManagement

class VersionList(loci: String) {
    private val localVersions = LocalVersions(loci)
    private val onlineVersionNames = getOnlineVersionList()
    var allVersionNames = combineVersionLists().sortedDescending()
    val availableVersions = ArrayList<String>()

    private fun getOnlineVersionList(): ArrayList<String> {
        val versionList = ArrayList<String>()
        val directoryManagement = DirectoryManagement()
//        val versionFileLocation = FileManagement.createFile(
//            directoryManagement.setLociLocation(loci),
//            "onlineVersions",
//            "txt")
//        val versionsFile = localVersions.returnOnlineVersionFile()
//        versionsFile.forEachLine {
//            versionList.add(it.name)
//        }
        return versionList
    }

    private fun combineVersionLists(): ArrayList<String> {
        val localVersionNames = ArrayList<String>()
        // arraylist of Version objects
        localVersions.versionsList.forEach {
            localVersionNames.add(it.name)
        }
         onlineVersionNames.union(localVersionNames)
        return localVersionNames
    }

    private fun createVersionList() {

    }


}