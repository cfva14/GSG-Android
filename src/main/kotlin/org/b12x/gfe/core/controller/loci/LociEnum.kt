package org.b12x.gfe.core.controller.loci

sealed interface LociEnum {
    val fullName: String
    val exons: Int
    // val allEnumLocus: List<LociEnum>
}