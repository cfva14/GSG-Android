package org.b12x.gfe.utilities

class LociLocations {

    private val USER_DIRECTORY = System.getProperty("user.home")

    fun determineLociFolder(loci: String): String {
        val dataFolder = when (loci) {
            "HLA" -> "/Documents/GSG/GSGData/HLA/"
            "KIR" -> "/Documents/GSG/GSGData/KIR/"
            "ABO" -> "/Documents/GSG/GSGData/ABO/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                "/Documents/GSG/GSGData/$loci/"
            }
        }
        return USER_DIRECTORY + dataFolder
    }
}