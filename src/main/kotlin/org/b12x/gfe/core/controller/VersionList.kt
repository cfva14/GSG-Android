package org.b12x.gfe.core.controller

class VersionList {
    private val localVersions = LocalVersions("HLA")
    private val localVersionNames = localVersions.getVersionFolderNames()
    private val onlineVersionNames = getOnlineVersionList()
    val allVersionNames = onlineVersionNames.union(localVersionNames)
    val availableVersions = ArrayList<String>()

    private fun getOnlineVersionList(): ArrayList<String> {
        val versionList = ArrayList<String>()
        val versionsFile = localVersions.returnOnlineVersionFile()
        versionsFile.forEachLine {
            versionList.add(it)
        }
        return versionList
    }

    private fun createVersionList() {

    }


}