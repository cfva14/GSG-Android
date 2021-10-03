package org.b12x.gfe.core.controller

class VersionList {
    private val localData = ReadLocalData("HLA")
    private val localVersionNames = localData.getSubFolderNames()
    private val onlineVersionNames = getOnlineVersionList()
    val completeVersionSet = (localVersionNames + onlineVersionNames).toSet()

    private fun getOnlineVersionList(): ArrayList<String> {
        val versionList = ArrayList<String>()
        val versionsFile = localData.returnOnlineVersionFile()
        versionsFile.forEachLine {
            versionList.add(it)
        }
        return versionList
    }



}