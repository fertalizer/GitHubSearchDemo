package com.mark.githubsearchdemo.api

import android.util.Log
import com.mark.githubsearchdemo.Constant
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class Client {

    @Throws(IOException::class)
    fun get(url: String): String {

        var client: OkHttpClient = OkHttpClient()
        var request = Request.Builder()
                    .url(url)
                    .build()
        var response: Response = client.newCall(request).execute()

        return doResponse(response)


    }

    private fun doResponse(response: Response): String {
        if (response.isSuccessful) {
            var responseData = response.body()!!.string()
            Log.d(Constant.TAG, "" + response.header("Link"))
            return responseData
        } else {
            throw IOException("Unexpected code " + response)
        }
    }
}