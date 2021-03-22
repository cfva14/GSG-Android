package org.b12x.gfe.core.model

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class DataDownload {
    private val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()

    fun makeRequest(url: String, request: String): String {
        val okHttpClient = OkHttpClient()
        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest(url, request)).execute())
        return parsedResponse
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