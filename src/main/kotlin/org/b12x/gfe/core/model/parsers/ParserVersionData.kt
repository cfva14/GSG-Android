package org.b12x.gfe.core.model.parsers

import com.beust.klaxon.JsonArray
import com.beust.klaxon.Parser
import okhttp3.Response
import org.b12x.gfe.utilities.FileManagement
import org.b12x.gfe.utilities.DirectoryManagement
import java.io.File

object ParserVersionData {

    private val directoryManagement = DirectoryManagement()

    // HLA Version API
    const val DB_VERSIONS = "http://gfe.b12x.org/v1/imgt-versions"

    /**
     * Parses incoming version data.
     *
     * @param loci what loci group the versions belong to
     * @param response the response from the call to the database
     */
    fun parseResponse(loci: String, response: Response) {
        val body = response.body?.string() ?: ""
        val stringBuilder: StringBuilder = StringBuilder(body)
        val parser: Parser = Parser.default()

        val parsedObject = parser.parse(stringBuilder) as JsonArray<String>
        println("Versions: $parsedObject")
        parsedObject.forEach {
            addVersion(loci, it)
            println("A version: $it")
        }
    }

    /**
     * Stores a version string.
     *
     * @param loci what loci group the version belongs to
     * @param version the version to be added
     */
    private fun addVersion(loci: String, version: String) {
        val versionFileLocation = FileManagement.createFile(
            directoryManagement.setLociLocation(loci),
            "onlineVersions",
            "txt")
        if(!File(versionFileLocation).readLines().contains(version)) {
            File(versionFileLocation).appendText("$version\n")
        }
    }
}