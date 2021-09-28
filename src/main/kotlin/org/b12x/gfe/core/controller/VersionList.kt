package org.b12x.gfe.core.controller

class VersionList {
    private val localData = ReadLocalData("HLA")
    val localVersionNames = localData.getSubFolders()
    val onlineVersionNames = getOnlineVersionList()
    val completeVersionList = ArrayList<String>()

    fun generateCompleteVersionList() {
        
    }

    private fun getOnlineVersionList(): ArrayList<String> {
        val versionList = ArrayList<String>()
        val versionsFile = localData.returnOnlineVersionFile()
        versionsFile.forEachLine {
            versionList.add(it)
        }
        return versionList
    }





}