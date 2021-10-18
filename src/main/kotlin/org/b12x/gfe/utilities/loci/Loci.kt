package org.b12x.gfe.utilities.loci

sealed interface Loci {
    val fullName: String
    val exons: Int
}