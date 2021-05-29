package com.lire.restful

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import kotlin.coroutines.CoroutineContext

/**
 * bangumi data view model
 *
 * @property bgmRepository 数据仓库
 */

class BgmDataViewModel(val bgmRepository: BgmRepository) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()

    /**
     * calendar字段
     * 获取返回的日历信息
     */

    private val _calendar = MutableLiveData<String>()
    val calendar : LiveData<String>
        get() = _calendar

    /**
     * failMsg字段
     * 失败返回的信息
     */

    private val _failMsg = MutableLiveData<String>()
    val failMsg : LiveData<String>
        get() = _failMsg

    /**
     * subjectInfo字段
     * 获取返回的节目信息
     */

    private val _subjectInfo = MutableLiveData<String>()
    val subjectInfo : LiveData<String>
        get() = _subjectInfo

    /**
     * searchResult字段
     * 获取搜索信息
     */

    private val _searchResult = MutableLiveData<String>()
    val searchResult : LiveData<String>
        get() = _searchResult

    /**
     * userInfo字段
     * 获取用户信息
     */

    private val _userInfo = MutableLiveData<String>()
    val userInfo : LiveData<String>
        get() = _userInfo

    /**
     * userWatching字段
     * 获取用户在看
     */

    private val _userWatching = MutableLiveData<String>()
    val userWatching : LiveData<String>
        get() = _userWatching

    /**
     * username字段
     * 托管的用户名字段
     */

    var usernameStr : MutableLiveData<String> = MutableLiveData()

    fun loadCalendarAsync() {
        viewModelScope.launch {

            val list = runCatching {
                bgmRepository.getCalendarAsync()
            }
            list.onSuccess {
                _calendar.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadSubjectInfoAsync(id : String) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getSubjectInfoAsync(id, "medium")
            }
            list.onSuccess {
                _subjectInfo.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadSearchResultAsync(content : String, start : Int) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getSearchResultAsync(content, start)
            }
            list.onSuccess {
                _searchResult.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadSearchResultWithTypeAsync(content : String, start: Int, type : Int) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getSearchResultWithTypeAsync(content, start, type)
            }
            list.onSuccess {
                _searchResult.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadUserInfoAsync(userName : String) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getUserInfoAsync(userName)
            }
            list.onSuccess {
                _userInfo.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadUserWatchingAsync(userName: String) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getUserWatchingAsync(userName)
            }
            list.onSuccess {
                _userWatching.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun setUserName(name : String) {
        usernameStr.value = name
    }

}