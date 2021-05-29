package com.lire.netdatahandler

import android.util.Log
import com.google.gson.JsonParser
import com.lire.userinfo.UserCollection
import com.lire.utils.getAsNullableInt
import com.lire.utils.getAsNullableJsonArray
import com.lire.utils.getAsNullableJsonObject
import com.lire.utils.getAsNullableString

/**
 * 处理Collection的Json
 *
 * @property JSONStr Json字符串
 */

class CollectionJsonHandler(val JSONStr : String) {
    fun parseJson() : List<UserCollection> {
        try {
            val arr = JsonParser.parseString(JSONStr).getAsNullableJsonArray()
            val list = mutableListOf<UserCollection>()
            arr?.map { e ->
                val obj = e.getAsNullableJsonObject()
                val subject = obj?.get("subject")?.getAsNullableJsonObject()
                val id = subject?.get("id")?.getAsNullableString()?:""
                val type = subject?.get("type")?.getAsNullableInt()?:0
                val name_jp = subject?.get("name")?.getAsNullableString()?:""
                val name_cn = subject?.get("name_cn")?.getAsNullableString()?:""
                val name = if(name_cn=="")  name_jp else name_cn
                val img = subject?.get("images")?.getAsNullableJsonObject()?.get("common")?.getAsNullableString()?:""
                val doingAmount = subject?.get("collection")?.getAsNullableJsonObject()?.get("doing")?.getAsNullableInt()?:0
                UserCollection(name, id, type, img, doingAmount)
            }?.toCollection(list)
//            println(list.map { it.toString() }.reduce { acc, userCollection -> acc + " " + userCollection })
//            Log.d("TAG", list.map { it.toString() }.reduce { acc, userCollection -> acc + " " + userCollection })
            return list
        } catch (e : Exception) {
            return listOf()
        }
    }
}