package com.lire.restful

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit的接口
 *
 */

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

    /**
     * 获取日历
     *
     * @return 日历对应的String
     */

    @GET("calendar")
    fun getCalendarAsync() : Call<String>

    /**
     * 获取节目信息
     *
     * @param id 节目id
     * @return 节目对应的String
     */

    @GET("subject/{id}?app_id=bgm18556097b70b84c73")
    fun getSubjectInfo(@Path("id") id : String) : Call<String>

    /**
     * 获取节目信息
     *
     * @param id 节目id
     * @param responseGroup 返回数据大小
     * @return 节目信息类
     */

    @GET("subject/{id}?app_id=bgm18556097b70b84c73")
    fun getSubjectInfo(@Path("id") id : String, @Query("responseGroup") responseGroup : String) : Call<String>

    /**
     * 获取搜索结果
     *
     * @param content 搜索字段
     * @param start 分页
     * @return 搜索结果
     */

    @GET("search/subject/{content}?app_id=bgm18556097b70b84c73&responseGroup=small")
    fun getSearchResult(@Path("content") content : String, @Query("start") start : Int) : Call<String>

    /**
     * 获取搜索结果
     *
     * @param content 搜索字段
     * @param start 分页
     * @param type 搜索范围类
     * @return 搜索结果
     */

    @GET("search/subject/{content}?app_id=bgm18556097b70b84c73&responseGroup=small")
    fun getSearchResult(@Path("content") content : String, @Query("start") start : Int, @Query("type") type : Int) : Call<String>

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */

    @GET("user/{username}?app_id=bgm18556097b70b84c73")
    fun getUserInfo(@Path("username") username : String) : Call<String>

    /**
     * 获取在看信息
     *
     * @param username 用户名
     * @return 在看
     */

    @GET("user/{username}/collection?app_id=bgm18556097b70b84c73&cat=all_watching")
    fun getCollectionInfo(@Path("username") username: String) : Call<String>

}