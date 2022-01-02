package org.b12x.gfe.utilities

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking

object InternetAccess {

    var internetAccess: Boolean = false

    fun isInternetAvailable(): Boolean {
        return runBlocking {
            try {
                ktorHttpClient.head<String>("http://google.com")
                true
            } catch (e: Exception) {
                println(e.message)
                false
            }
        }
    }

    val ktorHttpClient = HttpClient {}
}