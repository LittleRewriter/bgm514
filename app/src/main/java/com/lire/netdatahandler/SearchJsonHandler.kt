package com.lire.netdatahandler

import android.util.Log
import com.google.gson.JsonParser
import com.lire.searchview.SearchResult
import com.lire.utils.getAsNullableInt
import com.lire.utils.getAsNullableJsonArray
import com.lire.utils.getAsNullableJsonObject
import com.lire.utils.getAsNullableString

val searchJsonSample = """
    {
        "results": 1000,
        "list": [
            {
                "id": 45142,
                "url": "http:\/\/bgm.tv\/subject\/45142",
                "type": 4,
                "name": "A-GA \u301c\u6fc0\u52d5\u306e\u60d1\u661f\u301c",
                "name_cn": "A-GA\uff1a\u6fc0\u52a8\u7684\u60d1\u661f",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/72\/bb\/45142_e4C17.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/72\/bb\/45142_e4C17.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/72\/bb\/45142_e4C17.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/72\/bb\/45142_e4C17.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/72\/bb\/45142_e4C17.jpg"
                }
            },
            {
                "id": 8435,
                "url": "http:\/\/bgm.tv\/subject\/8435",
                "type": 1,
                "name": "A\u30c1\u30e3\u30f3\u30cd\u30eb",
                "name_cn": "A\u9891\u9053",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/ad\/16\/8435_8imYc.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/ad\/16\/8435_8imYc.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/ad\/16\/8435_8imYc.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/ad\/16\/8435_8imYc.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/ad\/16\/8435_8imYc.jpg"
                }
            },
            {
                "id": 20213,
                "url": "http:\/\/bgm.tv\/subject\/20213",
                "type": 1,
                "name": "A\u30fbD -\u5929\u4f7f\u306e\u5618-",
                "name_cn": "A\u00b7D-\u5929\u4f7f\u7684\u8c0e\u8a00-",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/0f\/29\/20213_x7aoF.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/0f\/29\/20213_x7aoF.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/0f\/29\/20213_x7aoF.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/0f\/29\/20213_x7aoF.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/0f\/29\/20213_x7aoF.jpg"
                }
            },
            {
                "id": 221292,
                "url": "http:\/\/bgm.tv\/subject\/221292",
                "type": 2,
                "name": "A.I.C.O. -Incarnation-",
                "name_cn": "A.I.C.O.\uff1a\u5316\u8eab",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/fb\/94\/221292_ehuqv.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/fb\/94\/221292_ehuqv.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/fb\/94\/221292_ehuqv.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/fb\/94\/221292_ehuqv.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/fb\/94\/221292_ehuqv.jpg"
                }
            },
            {
                "id": 324860,
                "url": "http:\/\/bgm.tv\/subject\/324860",
                "type": 4,
                "name": "A\u5217\u8eca\u3067\u884c\u3053\u3046 \u306f\u3058\u307e\u308b\u89b3\u5149\u8a08\u753b",
                "name_cn": "A\u5217\u8eca \u958b\u59cb\u5427 \u89c0\u5149\u958b\u767c\u8a08\u756b",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/96\/ff\/324860_j4brA.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/96\/ff\/324860_j4brA.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/96\/ff\/324860_j4brA.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/96\/ff\/324860_j4brA.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/96\/ff\/324860_j4brA.jpg"
                }
            },
            {
                "id": 165802,
                "url": "http:\/\/bgm.tv\/subject\/165802",
                "type": 2,
                "name": "A\u7ad9\u836f\u4e38",
                "name_cn": "A\u7ad9\u836f\u4e38",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/df\/a0\/165802_mmkE3.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/df\/a0\/165802_mmkE3.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/df\/a0\/165802_mmkE3.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/df\/a0\/165802_mmkE3.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/df\/a0\/165802_mmkE3.jpg"
                }
            },
            {
                "id": 168641,
                "url": "http:\/\/bgm.tv\/subject\/168641",
                "type": 2,
                "name": "A\u30b5\u30a4\u30ba \u30af\u30e9\u30b9\u30e1\u30a4\u30c8 Anime Edition",
                "name_cn": "A Size",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/03\/4a\/168641_1hPs0.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/03\/4a\/168641_1hPs0.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/03\/4a\/168641_1hPs0.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/03\/4a\/168641_1hPs0.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/03\/4a\/168641_1hPs0.jpg"
                }
            },
            {
                "id": 279643,
                "url": "http:\/\/bgm.tv\/subject\/279643",
                "type": 1,
                "name": "\uff21\u30e9\u30f3\u30af\u5192\u967a\u8005\u306e\u30b9\u30ed\u30fc\u30e9\u30a4\u30d5",
                "name_cn": "A\u7ea7\u5192\u9669\u8005\u7684\u7530\u56ed\u751f\u6d3b",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/6f\/70\/279643_HhH83.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/6f\/70\/279643_HhH83.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/6f\/70\/279643_HhH83.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/6f\/70\/279643_HhH83.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/6f\/70\/279643_HhH83.jpg"
                }
            },
            {
                "id": 326305,
                "url": "http:\/\/bgm.tv\/subject\/326305",
                "type": 4,
                "name": "A.I-\u8a18\u61b6\u5973\u795e",
                "name_cn": "A.I-\u8bb0\u5fc6\u5973\u795e",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/6f\/dc\/326305_zogDD.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/6f\/dc\/326305_zogDD.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/6f\/dc\/326305_zogDD.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/6f\/dc\/326305_zogDD.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/6f\/dc\/326305_zogDD.jpg"
                }
            },
            {
                "id": 8436,
                "url": "http:\/\/bgm.tv\/subject\/8436",
                "type": 1,
                "name": "A\u30c1\u30e3\u30f3\u30cd\u30eb 1",
                "name_cn": "A-Channel 1",
                "summary": "",
                "air_date": "",
                "air_weekday": 0,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/ca\/3a\/8436_A4l0d.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/ca\/3a\/8436_A4l0d.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/ca\/3a\/8436_A4l0d.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/ca\/3a\/8436_A4l0d.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/ca\/3a\/8436_A4l0d.jpg"
                }
            }
        ]
    }
""".trimIndent()

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