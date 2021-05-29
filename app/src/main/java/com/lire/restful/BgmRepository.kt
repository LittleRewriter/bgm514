package com.lire.restful

import okhttp3.Response

/**
 * 获取Bgm资源的接口
 *
 */

interface BgmRepository {
    // 异步获取日历信息
    suspend fun getCalendarAsync() : Resource<String>
    // 异步获取节目信息
    suspend fun getSubjectInfoAsync(id : String, responseGroup: String = "medium") : Resource<String>
    // 异步获取搜索结果
    suspend fun getSearchResultWithTypeAsync(content : String, start : Int,type : Int) : Resource<String>
    // 异步获取搜索结果
    suspend fun getSearchResultAsync(content : String, start : Int) : Resource<String>
    // 异步获取用户信息
    suspend fun getUserInfoAsync(username : String) : Resource<String>
    // 异步获取用户在看
    suspend fun getUserWatchingAsync(username: String) : Resource<String>
}