package org.b12x.gfe.utilities

import org.b12x.gfe.utilities.preference.Prefs
import tornadofx.getProperty

sealed class Loci {
    sealed class HLA : Loci() {
        // HLA Loci (val fullName: String, val exons: Int)
        data class A(val name: String = "HLA-A", val exons: Int = 8) : HLA()
        data class B(val name: String = "HLA-B", val exons: Int = 7) : HLA()
        data class C(val name: String = "HLA-C", val exons: Int = 8) : HLA()
        data class DPA1(val name: String = "HLA-DPA1", val exons: Int = 4) : HLA()
        data class DPB1(val name: String = "HLA-DPB1", val exons: Int = 5) : HLA()
        data class DQA1(val name: String = "HLA-DQA1", val exons: Int = 4) : HLA()
        data class DQB1(val name: String = "HLA-DQB1", val exons: Int = 6) : HLA()
        data class DRB1(val name: String = "HLA-DRB1", val exons: Int = 6) : HLA()
        data class DRB3(val name: String = "HLA-DRB3", val exons: Int = 6) : HLA()
        data class DRB4(val name: String = "HLA-DRB4", val exons: Int = 6) : HLA()
        data class DRB5(val name: String = "HLA-DRB5", val exons: Int = 6) : HLA()
    }


    val hlaLociObjects: List<HLA> = HLA::class.sealedSubclasses.mapNotNull { it.objectInstance }
//    var hlaLociNames = hlaLociObjects.forEach { it.get(fullName) }.sorted()


    sealed class KIR : Loci() {
        // KIR Loci (val fullName: String, val exons: Int, val skippedExons: List<Int>)
        data class KIR2DL1(
            val fullName: String = "KIR2DL1",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DL2(
            val fullName: String = "KIR2DL2",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DL3(
            val fullName: String = "KIR2DL3",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DL4(
            val fullName: String = "KIR2DL4",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf(4)
        ) : KIR() // 9 Exons missing Exon 4

        data class KIR2DL5(
            val fullName: String = "KIR2DL5",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf(4)
        ) : KIR() // 9 Exons missing Exon 4 (Ask Jill about A and B)

        data class KIR2DS1(
            val fullName: String = "KIR2DS1",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DS2(
            val fullName: String = "KIR2DS2",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DS3(
            val fullName: String = "KIR2DS3",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DS4(
            val fullName: String = "KIR2DS4",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR2DS5(
            val fullName: String = "KIR2DS5",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR3DL1(
            val fullName: String = "KIR3DL1",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR3DL2(
            val fullName: String = "KIR3DL2",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR3DL3(
            val fullName: String = "KIR3DL3",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf(6)
        ) : KIR() // 9 Exons missing Exon 6

        data class KIR3DS1(
            val fullName: String = "KIR3DS1",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons

        data class KIR3DP1(
            val fullName: String = "KIR3DP1",
            val exons: Int = 5,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 5 Exons (Ask Jill about Exon 2)

        data class KIR2DP1(
            val fullName: String = "KIR2DP1",
            val exons: Int = 9,
            val skippedExons: List<Int> = listOf()
        ) : KIR() // 9 Exons
    }
}

fun getHlaLoci(): List<Loci.HLA> = Loci.HLA::class.sealedSubclasses.mapNotNull { it.objectInstance }


fun setLociType(loci: String) = when (loci) {
    "HLA" -> Prefs.currentGfeSearchLociGroup = "HLA"
    "KIR" -> Prefs.currentGfeSearchLociGroup = "KIR"
    else -> Prefs.currentGfeSearchLociGroup = "HLA"
}

// HlaLoci.values().find { it.fullName == Prefs.currentGfeSearchLocusHla } ?: AllLoci.HlaLoci.A
// KirLoci.values().find { it.fullName == Prefs.currentGfeSearchLocusKir } ?: AllLoci.KirLoci.KIR2DL1

fun getLocusType(loci: String) = when (loci) {
    "HLA" -> getHlaType(Prefs.currentGfeSearchLocusHla) // HlaLoci.values().find { it.fullName == Prefs.currentGfeSearchLocusHla } ?: AllLoci.HlaLoci.A
    "KIR" -> getHlaType(Prefs.currentGfeSearchLocusKir) // KirLoci.values().find { it.fullName == Prefs.currentGfeSearchLocusKir } ?: AllLoci.KirLoci.KIR2DL1
    else -> Loci.HLA.A()
}

fun getHlaType(hla: String) = when (hla) {
    "A" -> Loci.HLA.A()
    "B" -> Loci.HLA.B()
    "C" -> Loci.HLA.C()
    "DPA1" -> Loci.HLA.DPA1()
    "DPB1" -> Loci.HLA.DPB1()
    "DQA1" -> Loci.HLA.DQA1()
    "DQB1" -> Loci.HLA.DQB1()
    "DRB1" -> Loci.HLA.DRB1()
    "DRB3" -> Loci.HLA.DRB3()
    "DRB4" -> Loci.HLA.DRB4()
    "DRB5" -> Loci.HLA.DRB5()
    else -> Loci.HLA.A()
}

private val userDirectory = System.getProperty("user.home")

/**
 * Sets the specific group of genes to be read.
 *
 * @params a string representing the target loci
 * @return a string to the location of the specified data directory
 */
fun setLociLocation(loci: String) = when (loci) {
    "HLA" -> "$userDirectory/Documents/GSG/GSGData/HLA/"
    "KIR" -> "$userDirectory/Documents/GSG/GSGData/KIR/"
    "ABO" -> "$userDirectory/Documents/GSG/GSGData/ABO/"
    "TEST" -> "$userDirectory/Documents/GSG/GSGData/TEST/"
    else -> {
        "$userDirectory/Documents/GSG/GSGData/$loci/"
    }
}
