package com.lire.netdatahandler

import com.google.gson.JsonParser
import org.json.JSONArray
import org.json.JSONObject

val testJson = """
    [
    {
        "weekday": {
            "en": "Mon",
            "cn": "\u661f\u671f\u4e00",
            "ja": "\u6708\u8000\u65e5",
            "id": 1
        },
        "items": [
            {
                "id": 294875,
                "url": "http:\/\/bgm.tv\/subject\/294875",
                "type": 2,
                "name": "\u6211\u771f\u7684\u6ca1\u7528\u54a9\uff1f",
                "name_cn": "\u6211\u771f\u7684\u6ca1\u7528\u54a9\uff1f",
                "summary": "",
                "air_date": "2021-04-19",
                "air_weekday": 1,
                "rating": {
                    "total": 2,
                    "count": {
                        "10": 0,
                        "9": 0,
                        "8": 0,
                        "7": 2,
                        "6": 0,
                        "5": 0,
                        "4": 0,
                        "3": 0,
                        "2": 0,
                        "1": 0
                    },
                    "score": 7
                },
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/8f\/1c\/294875_ZZPPi.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/8f\/1c\/294875_ZZPPi.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/8f\/1c\/294875_ZZPPi.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/8f\/1c\/294875_ZZPPi.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/8f\/1c\/294875_ZZPPi.jpg"
                },
                "collection": {
                    "doing": 15
                }
            },
            {
                "id": 297254,
                "url": "http:\/\/bgm.tv\/subject\/297254",
                "type": 2,
                "name": "\u3072\u3052\u3092\u5243\u308b\u3002\u305d\u3057\u3066\u5973\u5b50\u9ad8\u751f\u3092\u62fe\u3046\u3002",
                "name_cn": "\u5243\u987b\u3002\u7136\u540e\u6361\u5230\u5973\u9ad8\u4e2d\u751f\u3002",
                "summary": "",
                "air_date": "2021-04-05",
                "air_weekday": 1,
                "rating": {
                    "total": 620,
                    "count": {
                        "10": 24,
                        "9": 11,
                        "8": 61,
                        "7": 174,
                        "6": 180,
                        "5": 78,
                        "4": 38,
                        "3": 12,
                        "2": 10,
                        "1": 32
                    },
                    "score": 6.1
                },
                "rank": 5262,
                "images": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/e9\/78\/297254_kdK52.jpg",
                    "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/e9\/78\/297254_kdK52.jpg",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/e9\/78\/297254_kdK52.jpg",
                    "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/e9\/78\/297254_kdK52.jpg",
                    "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/e9\/78\/297254_kdK52.jpg"
                },
                "collection": {
                    "doing": 1753
                }
            }
        ]
    }]
""".trimIndent()

class CalendarJsonHandler (val JSONstr : String) {
    fun parseJson() {
        try {
            val parser = JsonParser()
            val element = parser.parse(JSONstr)
            if (element.isJsonArray()) {
                val arr = element.asJsonArray
                arr.forEach {
                    val items = it.asJsonObject.get("items")
                    items.asJsonArray.forEach {
                        val item = it.asJsonObject
                        val id = item.get("id").asString
                        val url = item.get("url").asString
                        val type = item.get("type").asInt
                        val name = item.get("name").asString
                        val name_cn = item.get("name_cn").asString
                        val air_weekday = item.get("air_weekday").asInt
                        val score = item.get("rating").asJsonObject.get("score").asDouble
                        val img = item.get("images").asJsonObject.get("medium").asString
                        val collection = item.get("collection").asJsonObject.get("doing").asString

                    }
                }
            }
        } catch (e : Exception) {

        }
    }
}