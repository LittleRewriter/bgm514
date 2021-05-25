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
    val staff : ArrayList<Staff>
)