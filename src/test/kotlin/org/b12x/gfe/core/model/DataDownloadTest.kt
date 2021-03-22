package org.b12x.gfe.core.model

import com.nhaarman.mockitokotlin2.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.b12x.gfe.core.model.DataDownload.*

class DataDownloadTest {
    private val dataDownload = DataDownload()
    private val testUrl = "https://jsonplaceholder.typicode.com/users/1"
    private val foaasUrl = "https://foaas.com/bag/VSC"

    @Test
    fun true_downloadTestData_FOAAS() {
        assertEquals("{ message: 'Eat a bag of fucking dicks.', subtitle: '- VSC' }",
            dataDownload.makeRequest(testUrl, ""))
    }

//    @Test
//    fun true_downloadVersionsHla_returnsData(){
//        var downloadedData = downloadVersions("HLA")
//    }


}