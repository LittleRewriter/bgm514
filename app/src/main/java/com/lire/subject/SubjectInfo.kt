package com.lire.subject

/**
 * 角色
 *
 * @property name 角色名
 * @property type 角色种类
 * @property cv 声优
 * @property img 图
 */

data class Chara(
    val name: String,
    val type : String,
    val cv : String,
    val img : String
)

/**
 * staff
 *
 * @property name staff名
 * @property role staff职位
 */

data class Staff (
    val name: String,
    val role : String
)

/**
 * subjet数据
 *
 * @property bangumiID 节目ID
 * @property jpName 日文名
 * @property cnName 中文名
 * @property type 类型
 * @property avgScore 均分
 * @property votes 评价人数
 * @property rank 排名
 * @property collectionAmount 收藏人数
 * @property sumChapter 总章节
 * @property viewedChapter 更新章节
 * @property sketch 梗概
 * @property character 角色
 * @property staff staff
 * @property typeStr 类型对应的str
 * @property imageURL 图片url
 */

data class SubjectInfo (
    val bangumiID : String,
    val jpName : String,
    val cnName : String,
    val type : TypeOfSubject,
    val avgScore : String,
    val votes : Int,
    val rank : String,
    val collectionAmount : ArrayList<Int>,
    val sumChapter : String,
    val viewedChapter : String,
    val sketch : String,
    val character : ArrayList<Chara>,
    val staff : ArrayList<Staff>,
    val typeStr : String,
    val imageURL : String
) {
    val tvValue
        get() = run {
            val typeName = when(type) {
                TypeOfSubject.BOOK -> "书籍"
                TypeOfSubject.ANIME -> "动画"
                TypeOfSubject.GAME -> "游戏"
                TypeOfSubject.REAL -> "三次元"
                TypeOfSubject.MUSIC -> "音乐"
            }
            "${typeName}   ${avgScore}（${votes} votes）" +
                    "\n rank ${rank}"
        }
    fun getCollectionValue(typ : Int) : String {
        val pre = when(typ) {
            0 -> "想看"
            1 -> "看过"
            2 -> "在看"
            3 -> "搁置"
            4 -> "抛弃"
            else -> ""
        }
        return "$pre ： ${collectionAmount?.get(typ) ?: ""}"
    }
}