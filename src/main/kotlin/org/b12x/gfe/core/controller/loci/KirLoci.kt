package org.b12x.gfe.core.controller.loci

enum class KirLoci(override val fullName: String, override val exons: Int, val skippedExons: List<Int>) : LociEnum {
    KIR2DL1("KIR2DL1", 9, emptyList()),
    KIR2DL2("KIR2DL2", 9, emptyList()),
    KIR2DL3("KIR2DL3", 9, emptyList()),
    KIR2DL4("KIR2DL4", 9, listOf(4)),
    KIR2DL5A("KIR2DL5A", 9, listOf(4)),
    KIR2DL5B("KIR2DL5B", 9, listOf(4)),
    KIR2DS1("KIR2DS1", 9, emptyList()),
    KIR2DS2("KIR2DS2", 9, emptyList()),
    KIR2DS3("KIR2DS3", 9, emptyList()),
    KIR2DS4("KIR2DS4", 9, emptyList()),
    KIR2DS5("KIR2DS5", 9, emptyList()),
    KIR3DL1("KIR3DL1", 9, emptyList()),
    KIR3DL2("KIR3DL2", 9, emptyList()),
    KIR3DL3("KIR3DL3", 9, listOf(6)),
    KIR3DS1("KIR3DS1", 9, emptyList()),
    KIR3DP1("KIR3DP1", 5, emptyList()), // sometimes missing exon 2
    KIR2DP1("KIR2DP1", 9, emptyList());

    override fun toString() = fullName
}