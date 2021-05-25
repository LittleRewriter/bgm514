package com.lire.subject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lire.netdatahandler.SubjectJsonParser
import com.lire.netdatahandler.subjectStr

class SubjectViewModel : ViewModel() {
    var subjectInfo : MutableLiveData<SubjectInfo> = MutableLiveData()
    fun createSubject() {
        subjectInfo.value = SubjectJsonParser(subjectStr).parseJson()
    }
    fun getTVValue() : String{
        val typeName = when(subjectInfo.value?.type) {
            TypeOfSubject.BOOK -> "书籍"
            TypeOfSubject.ANIME -> "动画"
            TypeOfSubject.GAME -> "游戏"
            TypeOfSubject.REAL -> "三次元"
            TypeOfSubject.MUSIC -> "音乐"
            null -> ""
        }
        val tvValue = "${typeName}   ${subjectInfo.value?.avgScore ?: "未知"}（${subjectInfo.value?.votes ?: "???"} votes）" +
                "\n rank ${subjectInfo.value?.rank ?: "未知"}"
        return tvValue
    }

    fun getCollectValue(typ : Int) : String {
        val pre = when(typ) {
            0 -> "想看"
            1 -> "看过"
            2 -> "在看"
            3 -> "搁置"
            4 -> "抛弃"
            else -> ""
        }
        return "$pre ： ${subjectInfo.value?.collectionAmount?.get(typ) ?: ""}"
    }

}