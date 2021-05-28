package com.lire.netdatahandler
import android.util.Log
import com.google.gson.JsonParser
import com.lire.subject.Chara
import com.lire.subject.Staff
import com.lire.subject.SubjectInfo
import com.lire.subject.TypeOfSubject
import com.lire.utils.*

class SubjectJsonParser(val JSONstr : String) {
    fun parseJson() : SubjectInfo? {
        try {
            val parser = JsonParser()
            val element = parser.parse(JSONstr)
//            Log.d("Subject", JSONstr)
            if (element.isJsonObject()) {
                val obj = element?.getAsNullableJsonObject()
                val id = obj?.get("id")?.getAsNullableString()?:""
                val type = obj?.get("type")?.getAsNullableInt()?:2
                val name = obj?.get("name")?.getAsNullableString()?:""
                val cnName = obj?.get("name_cn")?.getAsNullableString()?:""
                val summary = obj?.get("summary")?.getAsNullableString()?:""
                val rating = obj?.get("rating")?.getAsNullableJsonObject()
                val total_count = rating?.get("total")?.getAsNullableInt()?:0
                val score = rating?.get("score")?.getAsNullableDouble()?:0
                val rank = obj?.get("rank")?.getAsNullableString()?:""
                val eps = obj?.get("eps")?.getAsNullableDouble()?:0
                val epsCount = obj?.get("eps_count")?.getAsNullableDouble()?:0
                val image = obj?.get("images")?.getAsNullableJsonObject()?.get("common")?.getAsNullableString()?:""
                val collection = obj?.get("collection")?.getAsNullableJsonObject()
                val collection_num : ArrayList<Int> = ArrayList(listOf<Int>(
                    collection?.get("wish")?.getAsNullableInt()?:0,
                    collection?.get("collect")?.getAsNullableInt()?:0,
                    collection?.get("doing")?.getAsNullableInt() ?:0,
                    collection?.get("on_hold")?.getAsNullableInt() ?:0,
                    collection?.get("dropped")?.getAsNullableInt() ?:0
                ))
//                Log.d("Subject", "p1")
                val t = obj?.get("crt")
                val character_list = obj?.get("crt")?.getAsNullableJsonArray()
                val character_list_arr = ArrayList<Chara>()
                character_list?.forEach {
                    val characterName = it?.getAsNullableJsonObject()?.get("name")?.getAsNullableString()?:""
                    val name_cn = it?.getAsNullableJsonObject()?.get("name_cn")?.getAsNullableString()?:""
                    val show_name = when(name_cn == "") {
                        true -> characterName
                        else -> name_cn
                    }
                    val role_name = it?.getAsNullableJsonObject()?.get("role_name")?.getAsNullableString()?:""
//                    Log.d("Subject", "p2")
                    // 主角、配角
                    val img_src = it?.getAsNullableJsonObject()?.get("images")?.getAsNullableJsonObject()?.get("grid")?.getAsNullableString()?:""
                    val cv = it?.getAsNullableJsonObject()?.get("actors")?.getAsNullableJsonArray()?.map {
                        it.getAsNullableJsonObject()?.get("name")?.getAsNullableString()
                    }?.reduce { acc, s -> acc + " " + s }?:""
                    character_list_arr.add(Chara(show_name, role_name, cv, img_src))
                }


                val staff_list = obj?.get("staff")?.getAsNullableJsonArray()
                val staff_list_arr = ArrayList<Staff>()
                staff_list?.forEach {
                    val staffName = it?.getAsNullableJsonObject()?.get("name")?.getAsNullableString()?:""
                    val name_cn = it?.getAsNullableJsonObject()?.get("name_cn")?.getAsNullableString()?:""
                    val show_name = when(name_cn == "") {
                        true -> staffName
                        else -> name_cn
                    }
                    val jobs = it?.getAsNullableJsonObject()?.get("jobs")?.getAsNullableJsonArray()?.map { i -> i.getAsNullableString() }
                        ?.reduce{str, e -> str + " " + e}?:""
                    staff_list_arr.add(Staff(show_name, jobs))
                }

//                Log.d("Subject", "p3")

                val subject = SubjectInfo(
                    bangumiID = id,
                    jpName = name,
                    cnName = cnName,
                    type = when(type) {
                        1 -> TypeOfSubject.BOOK
                        2 -> TypeOfSubject.ANIME
                        3 -> TypeOfSubject.MUSIC
                        4 -> TypeOfSubject.GAME
                        6 -> TypeOfSubject.REAL
                        else -> TypeOfSubject.GAME
                    },
                    avgScore =  score.toString(),
                    votes = total_count,
                    rank = rank,
                    collectionAmount = collection_num,
                    sumChapter = epsCount.toString(),
                    viewedChapter = eps.toString(),
                    sketch = summary,
                    character = character_list_arr,
                    staff = staff_list_arr,
                    typeStr = when(type) {
                            1 -> "书籍"
                            2 -> "动画"
                            3 -> "游戏"
                            4 -> "三次元"
                            5 -> "音乐"
                            else -> ""
                        },
                    imageURL = image
                )
                return subject
            }
        } catch (e : Exception) {
            Log.e("Subject", "Not Obj")
            println(e.message)
        }
        return null
    }
}