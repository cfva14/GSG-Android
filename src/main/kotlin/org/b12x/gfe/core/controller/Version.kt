package org.b12x.gfe.core.controller

import org.b12x.gfe.utilities.loci.HlaLoci

data class Version(
    val name: String,
    val lociAvailable: ArrayList<String>
)