package org.b12x.gfe.core.controller

class VersionList {
    private val localVersions = LocalVersions("HLA")
    private val onlineVersionNames = getOnlineVersionList()
    val allVersionNames = combineVersionLists()
    val availableVersions = ArrayList<String>()

    private fun getOnlineVersionList(): ArrayList<String> {
        val versionList = ArrayList<String>()
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
        // onlineVersionNames.union(localVersionNames)
        return localVersionNames
    }

    private fun createVersionList() {

    }


}