package org.b12x.gfe.core.model
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
//import okio.

class JsonParser {

    private val mapper = jacksonObjectMapper()
    private val MEDIA_TYPE_JSON = "application/json; charset=utf-8".toMediaType()

    fun parseJson (incomingData: String): String {

        return mapper.readValue(incomingData)


    }

    fun makeRequest(url: String, request: String): String {
        val okHttpClient = OkHttpClient()
        val results: String
//        val parsedResponse = parseResponse(okHttpClient.newCall(createRequest(url, request)).execute())
        okHttpClient.newCall(createRequest(url, request)).execute().use { response ->
            results = mapper.readValue(response.body!!.source().toString())
        }
        return results
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