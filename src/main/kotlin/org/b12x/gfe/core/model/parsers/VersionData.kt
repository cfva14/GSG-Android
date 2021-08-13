package org.b12x.gfe.core.model.parsers

import com.beust.klaxon.JsonArray
import com.beust.klaxon.Parser
import okhttp3.Response
import org.b12x.gfe.core.model.DataDownload

object VersionData {

    const val DB_VERSIONS = "http://gfe.b12x.org/v1/imgt-versions"

    val dataDownload = DataDownload("versionData", DB_VERSIONS)

    fun parseResponse(response: Response): JsonArray<String> {
        val body = response.body?.string() ?: ""
        val stringBuilder: StringBuilder = StringBuilder(body)
        val parser: Parser = Parser.default()

        val parsedObject = parser.parse(stringBuilder) as JsonArray<String>
        println("Versions: ${parsedObject}")
        parsedObject.forEach {
            println("A version: $it")
        }
        return parsedObject
    }


}