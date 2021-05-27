package com.lire.subject

data class Chara(
    val name: String,
    val type : String,
    val cv : String,
    val img : String
)

data class Staff (
    val name: String,
    val role : String
)

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
                null -> ""
            }
            "${typeName}   ${avgScore ?: "未知"}（${votes ?: "???"} votes）" +
                    "\n rank ${rank ?: "未知"}"
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