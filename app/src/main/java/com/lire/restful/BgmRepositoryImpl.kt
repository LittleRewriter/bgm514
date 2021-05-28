package com.lire.restful

import android.util.Log
import com.lire.utils.logCoroutine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.lang.Exception

internal class BgmRepositoryImpl constructor(private val api:BgmAPI) : BgmRepository {
    override suspend fun getCalendarAsync(): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("Fetch", coroutineContext)
                val calendarListDeferred = async { api.getCalendarAsync().execute() }
                val calendarListResponse = calendarListDeferred.await()
                Log.e("TAG", calendarListResponse.body().toString())
                Resource.success(calendarListResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null, "failed")
            }
        }

    override suspend fun getSubjectInfoAsync(id: String, responseGroup: String): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("GetSubjectInfo", coroutineContext)
                val subjectInfoDeferred = async { api.getSubjectInfo(id, responseGroup).execute()}
                val subjectInfoResponse = subjectInfoDeferred.await()
                Log.e("TAG", subjectInfoResponse.body().toString())
                Resource.success(subjectInfoResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null, "failed")
            }
        }

    override suspend fun getSearchResultWithTypeAsync(content: String, start : Int, type: Int): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("GetResearchInfo", coroutineContext)
                val searchResultDeferred = async { api.getSearchResult(content, start, type).execute() }
                val searchResultResponse = searchResultDeferred.await()
                Resource.success(searchResultResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null, "failed")
            }
        }

    override suspend fun getSearchResultAsync(content: String, start: Int): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("GetSearchResult", coroutineContext)
                val searchResultDeferred = async { api.getSearchResult(content, start).execute() }
                val searchResultResponse = searchResultDeferred.await()
                Log.e("TAG", searchResultResponse.body().toString())
                Resource.success(searchResultResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null,"failed")
            }

        }

    override suspend fun getUserInfoAsync(username: String): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("GetUserInfo", coroutineContext)
                val userInfoDeferred = async { api.getUserInfo(username).execute() }
                val userInfoResponse = userInfoDeferred.await()
                Log.e("TAG", userInfoResponse.body().toString())
                Resource.success(userInfoResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null,"failed")
            }
    }

    override suspend fun getUserWatchingAsync(username: String): Resource<String> =
        withContext(Dispatchers.IO) {
            try {
                logCoroutine("GetUserWatching", coroutineContext)
                val watchingDeferred = async { api.getCollectionInfo(username).execute() }
                val watchingResponse = watchingDeferred.await()
                Log.e("TAG", watchingResponse.body().toString())
                Resource.success(watchingResponse.body().toString())
            } catch (e : Exception) {
                Resource.error(null, "failed")
            }
        }
}