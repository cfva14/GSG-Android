package org.b12x.gfe.core.controller

import java.io.File

data class Version(
    val folder: File,
    val name: String,
    val lociAvailable: ArrayList<String>
)