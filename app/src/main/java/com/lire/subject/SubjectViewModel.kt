package com.lire.subject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lire.netdatahandler.SubjectJsonParser

/**
 * 托管subject的View Model
 *
 */

class SubjectViewModel : ViewModel() {
    // 节目信息
    var subjectInfo : MutableLiveData<SubjectInfo> = MutableLiveData()
    // 是否点击了toolbar
    var isClickToolBar : MutableLiveData<Boolean> = MutableLiveData(false)

}