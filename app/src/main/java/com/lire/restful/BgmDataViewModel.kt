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

    fun loadCalendarAsync() {
        viewModelScope.launch {

            val list = runCatching {
                bgmRepository.getCalendarAsync()
            }
            list.onSuccess {
//                _calendar.value = it.data!!
            }.onFailure {
                _failMsg.value = it.message
            }
        }
    }

}