package org.b12x.gfe.core.model

import com.nhaarman.mockitokotlin2.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import tornadofx.ItemViewModel

class JsonParserTest {

    private val jsonParser = JsonParser()
    private val DBVERSIONS = "http://gfe.b12x.org/imgt-versions"
    private val incomingVersionData = "[\n  \"3.43.0\",\n  \"3.42.0\",\n  \"3.41.0\"\n]\n"

//    @Test
//    fun true_ParseJson_VersionData() {
//        assertEquals("[\"3.43.0\",\"3.42.0\",\"3.41.0\"]", jsonParser.makeRequest(DBVERSIONS, incomingVersionData))
//    }

}


