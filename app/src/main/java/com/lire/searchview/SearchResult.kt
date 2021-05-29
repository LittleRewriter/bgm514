package com.lire.searchview

import com.lire.subject.TypeOfSubject

/**
 * 搜索结果数据类
 *
 * @property id subject ID
 * @property type subject type
 * @property name subject name
 * @property imgUrl subject avatar url
 */

data class SearchResult(
    val id : String,
    val type : String,
    val name : String,
    val imgUrl : String
)
