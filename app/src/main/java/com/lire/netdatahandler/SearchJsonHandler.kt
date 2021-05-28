package com.lire.netdatahandler

import android.util.Log
import com.google.gson.JsonParser
import com.lire.searchview.SearchResult
import com.lire.utils.getAsNullableInt
import com.lire.utils.getAsNullableJsonArray
import com.lire.utils.getAsNullableJsonObject
import com.lire.utils.getAsNullableString

class SearchJsonHandler (val JSONStr : String){
    fun parseJson() : List<SearchResult> {
        try {
            val obj = JsonParser.parseString(JSONStr).getAsNullableJsonObject()
            val list = obj?.get("list")?.getAsNullableJsonArray()
            val res = mutableListOf<SearchResult>()
            list?.forEach {
                val e = it?.getAsNullableJsonObject()
                val id = e?.get("id")?.getAsNullableString()?:""
                val typ = e?.get("type")?.getAsNullableInt()?:0
                val typStr = when(typ) {
                    1 -> "书籍"
                    2 -> "动画"
                    3 -> "游戏"
                    4 -> "三次元"
                    5 -> "音乐"
                    else -> ""
                }
                val jp_name = e?.get("name")?.getAsNullableString()?:""
                val cn_name = e?.get("name_cn")?.getAsNullableString()
                val name = if (cn_name == null || cn_name == "") jp_name else cn_name
                val images = e ?.get("images")?.getAsNullableJsonObject()?.get("medium")?.getAsNullableString()?:""
                res.add(SearchResult(
                        id = id,
                        type = typStr,
                        name = name,
                        imgUrl = images
                ))
            }
            return res
        } catch (e : Exception) {
            e.printStackTrace()
            return listOf()
        }

    }
}