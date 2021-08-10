package org.b12x.gfe.core.model

//import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request

import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.net.URL
import javax.json.Json

//import java.net.URL

class DataDownload {
    private val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()
    private val DB_VERSIONS = "http://gfe.b12x.org/v1/imgt-versions"

    fun makeRequest(url: String, request: String): String {
        val okHttpClient = OkHttpClient()
//        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest(url, request)).execute())
        return parseResponse(okHttpClient.newCall(createRequest(DB_VERSIONS, request)).execute())
    }

    fun createRequest(url: String, request: String): Request {
        val body = request.toRequestBody(MEDIA_TYPE_JSON)
        return Request.Builder()
            .url(url)
//            .header(MEDIA_TYPE_JSON, "json")
//            .post(body)
            .build()
    }

    fun parseResponse(response: Response): String {
        val body = response.body?.string() ?: ""
        return body
    }
}