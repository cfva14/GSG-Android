package org.b12x.gfe

import org.b12x.gfe.utilities.InternetAccess
import tornadofx.launch
import java.io.File


fun main() {

    InternetAccess.internetAccess = InternetAccess.isInternetAvailable()
    println("Internet access? " + InternetAccess.internetAccess)

    launch<GSG>()


//    val notEmptyFolder = File("/Users/EatonK/Documents/GSG/GSGData/HLA/2.0.0/")
//    val emptyFolder = File("/Users/EatonK/Documents/GSG/GSGData/HLA/2.0.1/")
//    println(notEmptyFolder.list().size)//.list().toString())
//    println(notEmptyFolder.list().isNotEmpty())//.list().toString())
//
//    println(emptyFolder.list().size)
//    println(emptyFolder.list().isNotEmpty())//.list().toString())

}


