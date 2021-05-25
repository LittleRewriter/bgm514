package com.lire.restful

interface BgmRepository {
    suspend fun getCalendarAsync() : Resource<String>
}