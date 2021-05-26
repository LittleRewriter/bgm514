package com.lire.restful

import okhttp3.Response

interface BgmRepository {
    suspend fun getCalendarAsync() : Resource<String>
    suspend fun getSubjectInfoAsync(id : String, responseGroup: String = "medium") : Resource<String>
    suspend fun getSearchResultAsync(content : String) : Resource<String>
    suspend fun getUserInfoAsync(username : String) : Resource<String>
}