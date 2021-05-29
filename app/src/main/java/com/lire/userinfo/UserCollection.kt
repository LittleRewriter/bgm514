package com.lire.userinfo

/**
 * 用户收藏
 *
 * @property name name
 * @property id 节目id
 * @property type 节目种类
 * @property images 图片
 * @property doing 在看人数
 */

data class UserCollection(
        val name : String,
        val id : String,
        val type : Int,
        val images : String,
        val doing : Int
)
