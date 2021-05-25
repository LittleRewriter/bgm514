package com.lire.restful

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface BgmAPI {
    companion object {
        var baseURL = "https://api.bgm.tv/"
        val service : BgmAPI by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
            retrofit.create(BgmAPI::class.java)
        }
    }
    @GET("calendar")
    fun getCalendarAsync() : Call<String>
}