package com.lire.calendarview

/**
 * Bangumi信息的数据类
 *
 * @property id subject ID
 * @property bangumiName 番剧名
 * @property picURL 图片URL
 * @property collection 集合
 * @property jumpURL 跳转链接
 * @property avgScore 均分
 */
data class BangumiMsg(
    val id : String,
    val bangumiName : String,
    val picURL : String,
    val collection : Int,
    val jumpURL : String,
    val avgScore : Double
    )
