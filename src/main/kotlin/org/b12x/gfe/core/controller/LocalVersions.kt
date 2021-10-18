package org.b12x.gfe.core.controller

import org.b12x.gfe.utilities.LociLocations
import org.b12x.gfe.utilities.loci.HlaLoci
import org.b12x.gfe.utilities.loci.Loci
import java.io.File
import kotlin.reflect.KClass

class LocalVersions(loci: String) {

    private val gsgDataLocation = File(LociLocations.setLociLocation(loci))
    private val lociGroup: Loci = LociLocations.setLociType(loci)
    private val headerLength = 50  // bytes

    val dataFolders = ArrayList<Version>()


    /**
     * Gets all subfolders for a specific set of genes in the user's GSG data directory.
     * Hopefully these are all different version files, but the function does not screen for that.
     *
     * @return a list of folder names
     */
    fun getFolderNames(): ArrayList<String> {
        var lociAvailable = ArrayList<String>()
        gsgDataLocation.listFiles().forEach {
            if (it.exists() and it.isDirectory and folderContainsData(it)) {
                val version = Version(it.name.toString(), lociAvailable)
                dataFolders.add(version)
            }
        }
        return lociAvailable
    }

    // Check to see if there are any files in the folder with data in them
    // It doesn't matter how many
    private fun folderContainsData(folder: File) =
        folder.listFiles().any { fileContainsData(it) }

    // A file with only a header and no data is 50 bytes or fewer
    // (usually 18, but this gives some leeway to change the header)
    private fun fileContainsData(file: File) = file.length() > headerLength



    // get the locus name out of the file name
    private fun locusName(fileName: String) = fileName.split("_")[1]


//    fun returnOnlineVersionFile(): File {
//        val onlineVersionsFile = gsgDataLocation + "onlineVersions.txt"
//        if (FileManagement.doesFileExist(onlineVersionsFile)) {
//            return File(onlineVersionsFile)
//        }
//        runBlocking {
//            launch {
//                val dataDownload = DataDownload("HLA")
//                dataDownload.makeRequest(dataType = "version", dataUrl = ParserVersionData.DB_VERSIONS)
//            }
//        }
//        return File(onlineVersionsFile)
//    }

//    fun createVersion(): Version {
//        val lociAvailable: ArrayList<Loci> // <HlaLoci>
//        if (folderContainsData(gsgDataLocation)) {
//
//            lociGroup.find { it.fullName == locusName(it) } ?: HlaLoci.A
//        }
//        return Version()
//    }

    // Return the
    private fun findHlaLocus(file: File): HlaLoci =
        HlaLoci.values().find { it.fullName == locusName(file.name) } ?: HlaLoci.A

//     HlaLoci.values().find { it.fullName == locusName(fileName) }
// GfeSearchComboBoxLocus.kt ln 26
}