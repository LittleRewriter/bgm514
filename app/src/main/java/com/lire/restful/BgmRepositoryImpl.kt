package com.lire.restful

import android.util.Log
import com.lire.utils.logCoroutine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

internal class BgmRepositoryImpl constructor(private val api:BgmAPI) : BgmRepository {
    override suspend fun getCalendarAsync(): Resource<String> =
        withContext(Dispatchers.IO) {
            logCoroutine("Fetch", coroutineContext)
            val calendarListDeffered = async { api.getCalendarAsync() }
            val calendarListResponse = calendarListDeffered.await()
            Log.e("TAG", calendarListResponse.execute().body().toString())
            Resource.error("", "")
        }
}