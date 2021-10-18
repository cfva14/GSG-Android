package org.b12x.gfe.utilities

import org.b12x.gfe.plugins.gfesearch.view.GfeSearchViewParent
import org.b12x.gfe.utilities.loci.Loci
import org.b12x.gfe.utilities.loci.HlaLoci
import org.b12x.gfe.utilities.loci.KirLoci
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType

object LociLocations {

    private val userDirectory = System.getProperty("user.home")

    /**
     * Sets the specific group of genes to be read.
     *
     * @params a string representing the target loci
     * @return a string to the location of the specified data directory
     */
    fun setLociLocation(loci: String): String {
        return when (loci) {
            "HLA" -> "$userDirectory/Documents/GSG/GSGData/HLA/"
            "KIR" -> "$userDirectory/Documents/GSG/GSGData/KIR/"
            "ABO" -> "$userDirectory/Documents/GSG/GSGData/ABO/"
            "TEST" -> "$userDirectory/Documents/GSG/GSGData/TEST/"
            else -> {
                "$userDirectory/Documents/GSG/GSGData/$loci/"
            }
        }
    }

    fun setLociType(loci: String): Loci {
        return when (loci) {
            "HLA" -> HlaLoci::class as Loci //?: HlaLoci::class
//            "HLA" -> HlaLoci::class.createInstance()
            "KIR" -> KirLoci::class as Loci
            else -> {
                Loci::class.objectInstance as HlaLoci
            }
        }
    }
}
