package org.b12x.gfe.core.model

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.b12x.gfe.core.model.parsers.VersionData

/**
 * Downloads data as indicated
 *
 * @param requestType what kind of data you are requesting, HLA, KIR, or versionData
 * @param dataUrl the URL to the appropriate database API
 */
class DataDownload(requestType: String, dataUrl: String) {
    private val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()
    private val MEDIA_TYPE_TEXT = "application/txt; charset=utf-8".toMediaType()
    private val DB_VERSIONS = "http://gfe.b12x.org/v1/imgt-versions"
    private val url = dataUrl
    private val type = requestType
    private val loci = "HLA"

    /**
     * Requests data from the GFE database
     *
     * @param request some sort of OKHttp request, probably necessary for getting non-version data, empty string works fine
     */
    fun makeRequest(request: String = "") {
        val okHttpClient = OkHttpClient()
//        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest(url, request)).execute())
        parseResponse(okHttpClient.newCall(createRequest(url, request)).execute())
    }

    private fun createRequest(url: String, request: String): Request {
        val body = request.toRequestBody(MEDIA_TYPE_JSON)
        return Request.Builder()
            .url(url)
//            .header(MEDIA_TYPE_JSON, "json")
//            .post(body)
            .build()
    }

    private fun parseResponse(response: Response) {

        when (type) {
            "versionData" -> VersionData.parseResponse(loci, response)
            "hlaData" -> "/Documents/GSG/GSGData/HLA/"
            "TEST" -> "/Documents/GSG/GSGData/TEST/"
            else -> {
                null // do nothing
            }
        }

//        val body = response.body?.string() ?: ""
//        val stringBuilder: StringBuilder = StringBuilder(body)
//        val parser: Parser = Parser.default()
//
//        val parsedObject = parser.parse(stringBuilder) as JsonArray<String>
//        println("Versions: ${parsedObject}")
//        parsedObject.forEach {
//            println("A version: $it")
//        }
    }
}