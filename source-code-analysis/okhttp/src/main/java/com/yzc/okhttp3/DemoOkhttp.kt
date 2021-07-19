package com.yzc.okhttp3

import okhttp3.*
import java.io.IOException

object DemoOkhttp {

    @JvmStatic
    fun main(args: Array<String>) {

        val url = "https://api.github.com/users/rengwuxian/repos"

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                println("Response status code: ${response.code}")
            }
        })
    }

}