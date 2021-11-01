package org.b12x.gfe.core.controller.loci

enum class LociKir(val exons: Int, val skippedExons: List<Int>) {
    KIR2DL1(9, listOf()),
    KIR2DL2(9, listOf()),
    KIR2DL3(9, listOf()),
    KIR2DL4(9, listOf(4)),
    KIR2DL5A(9, listOf(4)),
    KIR2DL5B(9, listOf(4)),
    KIR2DS1(9, listOf()),
    KIR2DS2(9, listOf()),
    KIR2DS3(9, listOf()),
    KIR2DS4(9, listOf()),
    KIR2DS5(9, listOf()),
    KIR3DL1(9, listOf()),
    KIR3DL2(9, listOf()),
    KIR3DL3(9, listOf(6)),
    KIR3DS1(9, listOf()),
    KIR3DP1(5, listOf()), // sometime exon 2
    KIR2DP1(9, listOf())
}