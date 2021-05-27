package com.lire.restful

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    @GET("subject/{id}?app_id=bgm18556097b70b84c73")
    fun getSubjectInfo(@Path("id") id : String) : Call<String>

    @GET("subject/{id}?app_id=bgm18556097b70b84c73")
    fun getSubjectInfo(@Path("id") id : String, @Query("responseGroup") responseGroup : String) : Call<String>

    @GET("search/subject/{content}?app_id=bgm18556097b70b84c73&responseGroup=small")
    fun getSearchResult(@Path("content") content : String, @Query("start") start : Int) : Call<String>

    @GET("user/{username}?app_id=bgm18556097b70b84c73")
    fun getUserInfo(@Path("username") username : String) : Call<String>

    @GET("user/{username}/collections/{type}?app_id=bgm18556097b70b84c73")
    fun getCollectionInfo(@Path("username") username: String, @Path("type") type:String) : Call<String>

    @GET("user/{username}/collections/{type}?app_id=bgm18556097b70b84c73")
    fun getCollectionInfo(@Path("username") username: String, @Path("type") type:String, @Query("max_result") max_result:Int) : Call<String>

}