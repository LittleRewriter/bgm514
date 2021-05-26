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

class BgmDataViewModel(val bgmRepository: BgmRepository) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob()
    private val _calendar = MutableLiveData<String>()
    val calendar : LiveData<String>
        get() = _calendar

    private val _failMsg = MutableLiveData<String>()
    val failMsg : LiveData<String>
        get() = _failMsg

    private val _subjectInfo = MutableLiveData<String>()
    val subjectInfo : LiveData<String>
        get() = _subjectInfo

    private val _searchResult = MutableLiveData<String>()
    val searchResult : LiveData<String>
        get() = _searchResult

    private val _userInfo = MutableLiveData<String>()
    val userInfo : LiveData<String>
        get() = _userInfo

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
                bgmRepository.getSubjectInfoAsync(id)
            }
            list.onSuccess {
                _subjectInfo.value = it.data ?: ""
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

    fun loadSearchResultAsync(content : String) {
        viewModelScope.launch {
            val list = runCatching {
                bgmRepository.getSearchResultAsync(content)
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

}