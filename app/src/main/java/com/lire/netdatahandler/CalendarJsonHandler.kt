package com.lire.netdatahandler

import com.google.gson.JsonParser
import com.lire.calendarview.BangumiMsg
import com.lire.calendarview.BangumiMsgManager
import com.lire.utils.*
import org.json.JSONArray
import org.json.JSONObject


class CalendarJsonHandler (val JSONstr : String) {
    fun parseJson() {
        try {
            val parser = JsonParser()
            val element = parser.parse(JSONstr)
            if (element.isJsonArray()) {
                val arr = element?.getAsNullableJsonArray()
                arr?.forEach {
                    val items = it?.getAsNullableJsonObject()?.get("items")
                    items?.getAsNullableJsonArray()?.forEach {
                        val item = it?.getAsNullableJsonObject()
                        val id = item?.get("id")?.getAsNullableString()?:""
                        val url = item?.get("url")?.getAsNullableString()?:""
                        val type = item?.get("type")?.getAsNullableInt()?:2
                        val name = item?.get("name")?.getAsNullableString()?:""
                        val name_cn = item?.get("name_cn")?.getAsNullableString()?:""
                        val air_weekday = item?.get("air_weekday")?.getAsNullableInt()?:0
                        val score = item?.get("rating")?.getAsNullableJsonObject()?.get("score")?.getAsNullableDouble()?:0.0
                        val img = item?.get("images")?.getAsNullableJsonObject()?.get("medium")?.getAsNullableString()?:""
                        val collection = item?.get("collection")?.getAsNullableJsonObject()?.get("doing")?.getAsNullableInt()?:0
                        BangumiMsgManager.getInstance().addMsgForWeekDay(air_weekday-1, BangumiMsg(
                                id,
                                when {
                                    name_cn == "" -> name
                                    else -> name_cn
                                },img, collection, url, score
                        ))
                    }
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}