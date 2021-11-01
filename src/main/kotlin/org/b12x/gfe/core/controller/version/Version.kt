package org.b12x.gfe.core.controller.version

import java.io.File

data class Version(
    val folder: File,
    val name: String,
    val locusAvailable: ArrayList<String>
)