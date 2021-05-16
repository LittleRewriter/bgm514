package com.lire.netdatahandler

import com.google.gson.JsonParser
import com.lire.calendarview.BangumiMsg
import com.lire.calendarview.BangumiMsgManager
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
                },
                {
                    "id": 297456,
                    "url": "http:\/\/bgm.tv\/subject\/297456",
                    "type": 2,
                    "name": "\u604b\u3068\u547c\u3076\u306b\u306f\u6c17\u6301\u3061\u60aa\u3044",
                    "name_cn": "\u8fd9\u5982\u679c\u53eb\u4f5c\u7231\u60c5 \u611f\u89c9\u4f1a\u5f88\u6076\u5fc3",
                    "summary": "",
                    "air_date": "2021-04-05",
                    "air_weekday": 1,
                    "rating": {
                        "total": 149,
                        "count": {
                            "10": 3,
                            "9": 0,
                            "8": 10,
                            "7": 34,
                            "6": 49,
                            "5": 29,
                            "4": 14,
                            "3": 3,
                            "2": 3,
                            "1": 4
                        },
                        "score": 5.8
                    },
                    "rank": 5268,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/55\/0c\/297456_PdjJd.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/55\/0c\/297456_PdjJd.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/55\/0c\/297456_PdjJd.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/55\/0c\/297456_PdjJd.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/55\/0c\/297456_PdjJd.jpg"
                    },
                    "collection": {
                        "doing": 439
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Tue",
                "cn": "\u661f\u671f\u4e8c",
                "ja": "\u706b\u8000\u65e5",
                "id": 2
            },
            "items": [
                {
                    "id": 299673,
                    "url": "http:\/\/bgm.tv\/subject\/299673",
                    "type": 2,
                    "name": "\u8ee2\u30b9\u30e9\u65e5\u8a18 \u8ee2\u751f\u3057\u305f\u3089\u30b9\u30e9\u30a4\u30e0\u3060\u3063\u305f\u4ef6",
                    "name_cn": "\u8f6c\u751f\u53f2\u83b1\u59c6\u65e5\u8bb0",
                    "summary": "",
                    "air_date": "2021-04-06",
                    "air_weekday": 2,
                    "rating": {
                        "total": 155,
                        "count": {
                            "10": 8,
                            "9": 4,
                            "8": 24,
                            "7": 47,
                            "6": 62,
                            "5": 7,
                            "4": 2,
                            "3": 0,
                            "2": 1,
                            "1": 0
                        },
                        "score": 6.8
                    },
                    "rank": 2707,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/4f\/2f\/299673_l8B8U.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/4f\/2f\/299673_l8B8U.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/4f\/2f\/299673_l8B8U.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/4f\/2f\/299673_l8B8U.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/4f\/2f\/299673_l8B8U.jpg"
                    },
                    "collection": {
                        "doing": 764
                    }
                },
                {
                    "id": 314518,
                    "url": "http:\/\/bgm.tv\/subject\/314518",
                    "type": 2,
                    "name": "\u8056\u5973\u306e\u9b54\u529b\u306f\u4e07\u80fd\u3067\u3059",
                    "name_cn": "\u5723\u5973\u7684\u9b54\u529b\u662f\u4e07\u80fd\u7684",
                    "summary": "",
                    "air_date": "2021-04-06",
                    "air_weekday": 2,
                    "rating": {
                        "total": 145,
                        "count": {
                            "10": 1,
                            "9": 3,
                            "8": 11,
                            "7": 35,
                            "6": 58,
                            "5": 22,
                            "4": 8,
                            "3": 6,
                            "2": 0,
                            "1": 1
                        },
                        "score": 6.1
                    },
                    "rank": 4727,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/36\/cc\/314518_H8mV6.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/36\/cc\/314518_H8mV6.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/36\/cc\/314518_H8mV6.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/36\/cc\/314518_H8mV6.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/36\/cc\/314518_H8mV6.jpg"
                    },
                    "collection": {
                        "doing": 562
                    }
                },
                {
                    "id": 320222,
                    "url": "http:\/\/bgm.tv\/subject\/320222",
                    "type": 2,
                    "name": "\u674e\u6797\u514b\u7684\u5c0f\u9986\u513f",
                    "name_cn": "",
                    "summary": "",
                    "air_date": "2021-04-27",
                    "air_weekday": 2,
                    "rating": {
                        "total": 7,
                        "count": {
                            "10": 1,
                            "9": 0,
                            "8": 1,
                            "7": 1,
                            "6": 3,
                            "5": 1,
                            "4": 0,
                            "3": 0,
                            "2": 0,
                            "1": 0
                        },
                        "score": 6.9
                    },
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/1b\/e6\/320222_rp4K7.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/1b\/e6\/320222_rp4K7.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/1b\/e6\/320222_rp4K7.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/1b\/e6\/320222_rp4K7.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/1b\/e6\/320222_rp4K7.jpg"
                    },
                    "collection": {
                        "doing": 20
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Wed",
                "cn": "\u661f\u671f\u4e09",
                "ja": "\u6c34\u8000\u65e5",
                "id": 3
            },
            "items": [
                {
                    "id": 294337,
                    "url": "http:\/\/bgm.tv\/subject\/294337",
                    "type": 2,
                    "name": "\u30b9\u30fc\u30d1\u30fc\u30ab\u30d6",
                    "name_cn": "\u672c\u7530\u5c0f\u72fc\u4e0e\u6211",
                    "summary": "",
                    "air_date": "2021-04-07",
                    "air_weekday": 3,
                    "rating": {
                        "total": 550,
                        "count": {
                            "10": 23,
                            "9": 57,
                            "8": 270,
                            "7": 146,
                            "6": 38,
                            "5": 10,
                            "4": 3,
                            "3": 2,
                            "2": 0,
                            "1": 1
                        },
                        "score": 7.7
                    },
                    "rank": 572,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/1a\/de\/294337_tgGL6.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/1a\/de\/294337_tgGL6.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/1a\/de\/294337_tgGL6.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/1a\/de\/294337_tgGL6.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/1a\/de\/294337_tgGL6.jpg"
                    },
                    "collection": {
                        "doing": 1974
                    }
                },
                {
                    "id": 294864,
                    "url": "http:\/\/bgm.tv\/subject\/294864",
                    "type": 2,
                    "name": "\u4e24\u4e0d\u7591",
                    "name_cn": "",
                    "summary": "",
                    "air_date": "2021-04-21",
                    "air_weekday": 3,
                    "rating": {
                        "total": 6,
                        "count": {
                            "10": 0,
                            "9": 1,
                            "8": 2,
                            "7": 3,
                            "6": 0,
                            "5": 0,
                            "4": 0,
                            "3": 0,
                            "2": 0,
                            "1": 0
                        },
                        "score": 7.7
                    },
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/9b\/1d\/294864_li8Rn.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/9b\/1d\/294864_li8Rn.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/9b\/1d\/294864_li8Rn.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/9b\/1d\/294864_li8Rn.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/9b\/1d\/294864_li8Rn.jpg"
                    },
                    "collection": {
                        "doing": 26
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Thu",
                "cn": "\u661f\u671f\u56db",
                "ja": "\u6728\u8000\u65e5",
                "id": 4
            },
            "items": [
                {
                    "id": 277360,
                    "url": "http:\/\/bgm.tv\/subject\/277360",
                    "type": 2,
                    "name": "Yasuke -\u30e4\u30b9\u30b1-",
                    "name_cn": "\u6b66\u58eb\u5f25\u52a9",
                    "summary": "",
                    "air_date": "2021-04-29",
                    "air_weekday": 4,
                    "rating": {
                        "total": 44,
                        "count": {
                            "10": 0,
                            "9": 0,
                            "8": 0,
                            "7": 4,
                            "6": 3,
                            "5": 8,
                            "4": 12,
                            "3": 10,
                            "2": 4,
                            "1": 3
                        },
                        "score": 4
                    },
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/2e\/9a\/277360_W23A2.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/2e\/9a\/277360_W23A2.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/2e\/9a\/277360_W23A2.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/2e\/9a\/277360_W23A2.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/2e\/9a\/277360_W23A2.jpg"
                    },
                    "collection": {
                        "doing": 68
                    }
                },
                {
                    "id": 287488,
                    "url": "http:\/\/bgm.tv\/subject\/287488",
                    "type": 2,
                    "name": "\u30be\u30f3\u30d3\u30e9\u30f3\u30c9\u30b5\u30ac \u30ea\u30d9\u30f3\u30b8",
                    "name_cn": "\u4f50\u8d3a\u5076\u50cf\u662f\u4f20\u5947 \u590d\u4ec7",
                    "summary": "",
                    "air_date": "2021-04-08",
                    "air_weekday": 4,
                    "rating": {
                        "total": 528,
                        "count": {
                            "10": 24,
                            "9": 50,
                            "8": 222,
                            "7": 168,
                            "6": 45,
                            "5": 11,
                            "4": 6,
                            "3": 1,
                            "2": 0,
                            "1": 1
                        },
                        "score": 7.6
                    },
                    "rank": 741,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/02\/c7\/287488_1FJYC.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/02\/c7\/287488_1FJYC.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/02\/c7\/287488_1FJYC.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/02\/c7\/287488_1FJYC.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/02\/c7\/287488_1FJYC.jpg"
                    },
                    "collection": {
                        "doing": 2296
                    }
                },
                {
                    "id": 303864,
                    "url": "http:\/\/bgm.tv\/subject\/303864",
                    "type": 2,
                    "name": "\u7570\u4e16\u754c\u9b54\u738b\u3068\u53ec\u559a\u5c11\u5973\u306e\u5974\u96b7\u9b54\u8853\u03a9",
                    "name_cn": "\u5f02\u4e16\u754c\u9b54\u738b\u4e0e\u53ec\u5524\u5c11\u5973\u7684\u5974\u96b6\u9b54\u672fOMEGA",
                    "summary": "",
                    "air_date": "2021-04-08",
                    "air_weekday": 4,
                    "rating": {
                        "total": 155,
                        "count": {
                            "10": 5,
                            "9": 1,
                            "8": 16,
                            "7": 59,
                            "6": 55,
                            "5": 11,
                            "4": 4,
                            "3": 4,
                            "2": 0,
                            "1": 0
                        },
                        "score": 6.5
                    },
                    "rank": 3494,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/2e\/9b\/303864_md2TS.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/2e\/9b\/303864_md2TS.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/2e\/9b\/303864_md2TS.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/2e\/9b\/303864_md2TS.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/2e\/9b\/303864_md2TS.jpg"
                    },
                    "collection": {
                        "doing": 744
                    }
                },
                {
                    "id": 308558,
                    "url": "http:\/\/bgm.tv\/subject\/308558",
                    "type": 2,
                    "name": "SHAMAN KING",
                    "name_cn": "\u901a\u7075\u738b",
                    "summary": "",
                    "air_date": "2021-04-01",
                    "air_weekday": 4,
                    "rating": {
                        "total": 83,
                        "count": {
                            "10": 0,
                            "9": 0,
                            "8": 11,
                            "7": 18,
                            "6": 29,
                            "5": 13,
                            "4": 8,
                            "3": 4,
                            "2": 0,
                            "1": 0
                        },
                        "score": 6
                    },
                    "rank": 4452,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/e1\/78\/308558_n7D29.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/e1\/78\/308558_n7D29.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/e1\/78\/308558_n7D29.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/e1\/78\/308558_n7D29.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/e1\/78\/308558_n7D29.jpg"
                    },
                    "collection": {
                        "doing": 379
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Fri",
                "cn": "\u661f\u671f\u4e94",
                "ja": "\u91d1\u8000\u65e5",
                "id": 5
            },
            "items": [
                {
                    "id": 244224,
                    "url": "http:\/\/bgm.tv\/subject\/244224",
                    "type": 2,
                    "name": "\u5b8c\u7f8e\u4e16\u754c",
                    "name_cn": "\u5b8c\u7f8e\u4e16\u754c",
                    "summary": "",
                    "air_date": "2021-04-23",
                    "air_weekday": 5,
                    "rating": {
                        "total": 7,
                        "count": {
                            "10": 0,
                            "9": 0,
                            "8": 1,
                            "7": 3,
                            "6": 2,
                            "5": 0,
                            "4": 1,
                            "3": 0,
                            "2": 0,
                            "1": 0
                        },
                        "score": 6.4
                    },
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/36\/b7\/244224_gIqpB.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/36\/b7\/244224_gIqpB.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/36\/b7\/244224_gIqpB.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/36\/b7\/244224_gIqpB.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/36\/b7\/244224_gIqpB.jpg"
                    },
                    "collection": {
                        "doing": 29
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Sat",
                "cn": "\u661f\u671f\u516d",
                "ja": "\u571f\u8000\u65e5",
                "id": 6
            },
            "items": [
                {
                    "id": 899,
                    "url": "http:\/\/bgm.tv\/subject\/899",
                    "type": 2,
                    "name": "\u540d\u63a2\u5075\u30b3\u30ca\u30f3",
                    "name_cn": "\u540d\u4fa6\u63a2\u67ef\u5357",
                    "summary": "",
                    "air_date": "1996-01-08",
                    "air_weekday": 6,
                    "rating": {
                        "total": 4871,
                        "count": {
                            "10": 564,
                            "9": 568,
                            "8": 1456,
                            "7": 1520,
                            "6": 575,
                            "5": 142,
                            "4": 24,
                            "3": 6,
                            "2": 2,
                            "1": 14
                        },
                        "score": 7.7
                    },
                    "rank": 546,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/01\/88\/899_Q3F3X.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/01\/88\/899_Q3F3X.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/01\/88\/899_Q3F3X.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/01\/88\/899_Q3F3X.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/01\/88\/899_Q3F3X.jpg"
                    },
                    "collection": {
                        "doing": 3911
                    }
                },
                {
                    "id": 292969,
                    "url": "http:\/\/bgm.tv\/subject\/292969",
                    "type": 2,
                    "name": "\u30b9\u30e9\u30a4\u30e0\u5012\u3057\u3066300\u5e74\u3001\u77e5\u3089\u306a\u3044\u3046\u3061\u306b\u30ec\u30d9\u30ebMAX\u306b\u306a\u3063\u3066\u307e\u3057\u305f",
                    "name_cn": "\u6253\u4e86\u4e09\u767e\u5e74\u7684\u53f2\u83b1\u59c6\uff0c\u4e0d\u77e5\u4e0d\u89c9\u5c31\u7ec3\u5230\u4e86\u6ee1\u7b49",
                    "summary": "",
                    "air_date": "2021-04-10",
                    "air_weekday": 6,
                    "rating": {
                        "total": 375,
                        "count": {
                            "10": 6,
                            "9": 7,
                            "8": 41,
                            "7": 135,
                            "6": 125,
                            "5": 52,
                            "4": 4,
                            "3": 4,
                            "2": 1,
                            "1": 0
                        },
                        "score": 6.5
                    },
                    "rank": 3965,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/01\/e4\/292969_RLbg9.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/01\/e4\/292969_RLbg9.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/01\/e4\/292969_RLbg9.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/01\/e4\/292969_RLbg9.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/01\/e4\/292969_RLbg9.jpg"
                    },
                    "collection": {
                        "doing": 1379
                    }
                },
                {
                    "id": 294880,
                    "url": "http:\/\/bgm.tv\/subject\/294880",
                    "type": 2,
                    "name": "\u7f57\u5c0f\u9ed1\u6218\u8bb0 \u4f17\u751f\u4e4b\u95e8\u7bc7",
                    "name_cn": "\u7f57\u5c0f\u9ed1\u6218\u8bb0 \u4f17\u751f\u4e4b\u95e8\u7bc7",
                    "summary": "",
                    "air_date": "2021-04-24",
                    "air_weekday": 6,
                    "rating": {
                        "total": 96,
                        "count": {
                            "10": 12,
                            "9": 12,
                            "8": 47,
                            "7": 15,
                            "6": 6,
                            "5": 1,
                            "4": 2,
                            "3": 0,
                            "2": 0,
                            "1": 1
                        },
                        "score": 7.9
                    },
                    "rank": 552,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/dd\/f5\/294880_RkZ3u.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/dd\/f5\/294880_RkZ3u.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/dd\/f5\/294880_RkZ3u.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/dd\/f5\/294880_RkZ3u.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/dd\/f5\/294880_RkZ3u.jpg"
                    },
                    "collection": {
                        "doing": 303
                    }
                }
            ]
        },
        {
            "weekday": {
                "en": "Sun",
                "cn": "\u661f\u671f\u65e5",
                "ja": "\u65e5\u8000\u65e5",
                "id": 7
            },
            "items": [
                {
                    "id": 975,
                    "url": "http:\/\/bgm.tv\/subject\/975",
                    "type": 2,
                    "name": "ONE PIECE",
                    "name_cn": "\u6d77\u8d3c\u738b",
                    "summary": "",
                    "air_date": "1999-10-20",
                    "air_weekday": 7,
                    "rating": {
                        "total": 7114,
                        "count": {
                            "10": 2404,
                            "9": 1492,
                            "8": 1588,
                            "7": 899,
                            "6": 398,
                            "5": 177,
                            "4": 48,
                            "3": 21,
                            "2": 27,
                            "1": 60
                        },
                        "score": 8.4
                    },
                    "rank": 45,
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/92\/97\/975_YKuWd.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/92\/97\/975_YKuWd.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/92\/97\/975_YKuWd.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/92\/97\/975_YKuWd.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/92\/97\/975_YKuWd.jpg"
                    },
                    "collection": {
                        "doing": 6416
                    }
                },
                {
                    "id": 285777,
                    "url": "http:\/\/bgm.tv\/subject\/285777",
                    "type": 2,
                    "name": "\u76d7\u5893\u7b14\u8bb0\u4e4b\u79e6\u5cad\u795e\u6811",
                    "name_cn": "\u76d7\u5893\u7b14\u8bb0\u4e4b\u79e6\u5cad\u795e\u6811",
                    "summary": "",
                    "air_date": "2021-04-04",
                    "air_weekday": 7,
                    "rating": {
                        "total": 12,
                        "count": {
                            "10": 1,
                            "9": 0,
                            "8": 3,
                            "7": 4,
                            "6": 3,
                            "5": 0,
                            "4": 1,
                            "3": 0,
                            "2": 0,
                            "1": 0
                        },
                        "score": 7
                    },
                    "images": {
                        "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/f1\/46\/285777_V57NR.jpg",
                        "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/f1\/46\/285777_V57NR.jpg",
                        "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/f1\/46\/285777_V57NR.jpg",
                        "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/f1\/46\/285777_V57NR.jpg",
                        "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/f1\/46\/285777_V57NR.jpg"
                    },
                    "collection": {
                        "doing": 40
                    }
                }
            ]
        }
    ]
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
                        val collection = item.get("collection").asJsonObject.get("doing").asInt
                        BangumiMsgManager.getInstance().addMsgForWeekDay(air_weekday-1, BangumiMsg(
                                id,
                                when {
                                    name_cn == "" -> name
                                    else -> name_cn
                                },img, collection, url, score
                        ))
                        println(id + " " + url + " " + type + " "  + name + " " + name_cn + air_weekday + " " + score + " " + img + " " + collection)
                    }
                }
            }
        } catch (e : Exception) {

        }
    }
}