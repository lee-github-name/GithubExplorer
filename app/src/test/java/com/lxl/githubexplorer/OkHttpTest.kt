package com.lxl.githubexplorer

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Test
import java.util.logging.Logger

class OkHttpTest {


    @Test
    fun testRequest(){
        val mockWebServer = MockWebServer()
        mockWebServer.url("localhost")
        val logger = Logger.getLogger("OkHttpTest")
        val mockResponse = MockResponse().setResponseCode(200).setBody("ok")
        mockWebServer.enqueue(mockResponse)
        val okHttpClient = OkHttpClient.Builder().addInterceptor {
            val request = it.request()
            logger.info {
                "request = $request"
            }
            it.proceed(request)
            it.proceed(request)
        }.build()
        val request = Request.Builder().get().url("http://${mockWebServer.hostName}:${mockWebServer.port}").build()
        val response = okHttpClient.newCall(request).execute()
        Assert.assertEquals(200,response.code())
    }

}
