package org.b12x.gfe.core.model

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.b12x.gfe.core.model.parsers.ParserVersionData

/**
 * Downloads data as indicated
 *
 * @param loci what group of genes you are downloading data for
 */
class DataDownload(lociGroup: String) {
    private val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()
    private val MEDIA_TYPE_TEXT = "application/txt; charset=utf-8".toMediaType()
    private val loci = lociGroup

    /**
     * Requests data from the GFE database
     *
     * @param request some sort of OKHttp request, probably necessary for getting non-version data, empty string works fine
     * @param dataUrl the URL to the appropriate database API
     * @param dataType What kind of raw data (version or data)
     */
    fun makeRequest(request: String = "", dataUrl: String, dataType: String) {
        // TODO: check for internet access

        val okHttpClient = OkHttpClient()
        parseResponse(okHttpClient.newCall(createRequest(dataUrl, request)).execute(), dataType)
    }

    private fun createRequest(url: String, request: String): Request {
        val body = request.toRequestBody(MEDIA_TYPE_JSON)
        return Request.Builder()
            .url(url)
//            .header(MEDIA_TYPE_JSON, "json")
//            .post(body)
            .build()
    }

    private fun parseResponse(response: Response, dataType: String) {

        when (dataType) {
            "version" -> ParserVersionData.parseResponse(loci, response)
            "data" -> "/Documents/GSG/GSGData/$loci/"
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