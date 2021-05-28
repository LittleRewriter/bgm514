package com.lire.restful

import okhttp3.Response

interface BgmRepository {
    suspend fun getCalendarAsync() : Resource<String>
    suspend fun getSubjectInfoAsync(id : String, responseGroup: String = "medium") : Resource<String>
    suspend fun getSearchResultWithTypeAsync(content : String, start : Int,type : Int) : Resource<String>
    suspend fun getSearchResultAsync(content : String, start : Int) : Resource<String>
    suspend fun getUserInfoAsync(username : String) : Resource<String>
    suspend fun getUserWatchingAsync(username: String) : Resource<String>
}