package com.lire.baseappearance

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lire.netdatahandler.CollectionJsonHandler
import com.lire.netdatahandler.SearchJsonHandler
import com.lire.netdatahandler.UserInfoJsonParser
import com.lire.userinfo.UserInfo

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lire.baseappearance", appContext.packageName)
    }
    @Test
    fun testSearchJson() {
//        val searchJson = SearchJsonHandler()
//        searchJson.parseJson()
    }

    @Test
    fun testUserJson() {
        val userJson = UserInfoJsonParser("""
            {
                "id": 291948,
                "url": "http:\/\/bgm.tv\/user\/littlerewriter",
                "username": "littlerewriter",
                "nickname": "littlerewriter",
                "avatar": {
                    "large": "http:\/\/lain.bgm.tv\/pic\/user\/l\/000\/29\/19\/291948.jpg?r=1519282002",
                    "medium": "http:\/\/lain.bgm.tv\/pic\/user\/m\/000\/29\/19\/291948.jpg?r=1519282002",
                    "small": "http:\/\/lain.bgm.tv\/pic\/user\/s\/000\/29\/19\/291948.jpg?r=1519282002"
                },
                "sign": "\u6c38\u304d\u4e16\u306e \u9060\u306e\u7720\u308a\u306e \u307f\u306a\u76ee\u3056\u3081 \u6ce2\u4e57\u308a\u8239\u306e \u97f3\u306e\u3088\u304d ...",
                "usergroup": 10
            }
        """.trimIndent())
        println(userJson.parseJson())
        assertNotEquals(userJson.parseJson(), null)
    }

    @Test
    fun testCollectionJson() {
        val collectionJson = CollectionJsonHandler("""
            [
                {
                    "name": "\u604b\u3059\u308b\u5c0f\u60d1\u661f",
                    "subject_id": 276150,
                    "ep_status": 2,
                    "vol_status": 0,
                    "lasttouch": 1615729338,
                    "subject": {
                        "id": 276150,
                        "url": "http:\/\/bgm.tv\/subject\/276150",
                        "type": 2,
                        "name": "\u604b\u3059\u308b\u5c0f\u60d1\u661f",
                        "name_cn": "\u604b\u7231\u5c0f\u884c\u661f",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2020-01-03",
                        "air_weekday": 5,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/eb\/9f\/276150_tJJGx.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/eb\/9f\/276150_tJJGx.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/eb\/9f\/276150_tJJGx.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/eb\/9f\/276150_tJJGx.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/eb\/9f\/276150_tJJGx.jpg"
                        },
                        "collection": {
                            "doing": 610
                        }
                    }
                },
                {
                    "name": "\u5b89\u9054\u3068\u3057\u307e\u3080\u3089",
                    "subject_id": 282372,
                    "ep_status": 2,
                    "vol_status": 0,
                    "lasttouch": 1613621830,
                    "subject": {
                        "id": 282372,
                        "url": "http:\/\/bgm.tv\/subject\/282372",
                        "type": 2,
                        "name": "\u5b89\u9054\u3068\u3057\u307e\u3080\u3089",
                        "name_cn": "\u5b89\u8fbe\u4e0e\u5c9b\u6751",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2020-10-08",
                        "air_weekday": 4,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/0f\/a4\/282372_hzhyM.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/0f\/a4\/282372_hzhyM.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/0f\/a4\/282372_hzhyM.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/0f\/a4\/282372_hzhyM.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/0f\/a4\/282372_hzhyM.jpg"
                        },
                        "collection": {
                            "doing": 753
                        }
                    }
                },
                {
                    "name": "PUI PUI \u30e2\u30eb\u30ab\u30fc",
                    "subject_id": 325178,
                    "ep_status": 5,
                    "vol_status": 0,
                    "lasttouch": 1612416919,
                    "subject": {
                        "id": 325178,
                        "url": "http:\/\/bgm.tv\/subject\/325178",
                        "type": 2,
                        "name": "PUI PUI \u30e2\u30eb\u30ab\u30fc",
                        "name_cn": "PUI PUI \u5929\u7afa\u9f20\u8f66\u8f66",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2021-01-05",
                        "air_weekday": 2,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/e7\/6a\/325178_WwzcM.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/e7\/6a\/325178_WwzcM.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/e7\/6a\/325178_WwzcM.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/e7\/6a\/325178_WwzcM.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/e7\/6a\/325178_WwzcM.jpg"
                        },
                        "collection": {
                            "doing": 173
                        }
                    }
                },
                {
                    "name": "\u9b54\u5973\u306e\u65c5\u3005",
                    "subject_id": 292970,
                    "ep_status": 1,
                    "vol_status": 0,
                    "lasttouch": 1601686974,
                    "subject": {
                        "id": 292970,
                        "url": "http:\/\/bgm.tv\/subject\/292970",
                        "type": 2,
                        "name": "\u9b54\u5973\u306e\u65c5\u3005",
                        "name_cn": "\u9b54\u5973\u4e4b\u65c5",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2020-10-02",
                        "air_weekday": 5,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/99\/17\/292970_mxMxx.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/99\/17\/292970_mxMxx.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/99\/17\/292970_mxMxx.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/99\/17\/292970_mxMxx.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/99\/17\/292970_mxMxx.jpg"
                        },
                        "collection": {
                            "doing": 757
                        }
                    }
                },
                {
                    "name": "\u51b4\u3048\u306a\u3044\u5f7c\u5973\u306e\u80b2\u3066\u304b\u305f \u266d",
                    "subject_id": 132734,
                    "ep_status": 2,
                    "vol_status": 0,
                    "lasttouch": 1519281425,
                    "subject": {
                        "id": 132734,
                        "url": "http:\/\/bgm.tv\/subject\/132734",
                        "type": 2,
                        "name": "\u51b4\u3048\u306a\u3044\u5f7c\u5973\u306e\u80b2\u3066\u304b\u305f \u266d",
                        "name_cn": "\u8def\u4eba\u5973\u4e3b\u7684\u517b\u6210\u65b9\u6cd5 \u266d",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2017-04-06",
                        "air_weekday": 4,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/3a\/ce\/132734_m3fQm.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/3a\/ce\/132734_m3fQm.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/3a\/ce\/132734_m3fQm.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/3a\/ce\/132734_m3fQm.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/3a\/ce\/132734_m3fQm.jpg"
                        },
                        "collection": {
                            "doing": 493
                        }
                    }
                },
                {
                    "name": "\u3053\u306e\u7d20\u6674\u3089\u3057\u3044\u4e16\u754c\u306b\u795d\u798f\u3092\uff012",
                    "subject_id": 174043,
                    "ep_status": 4,
                    "vol_status": 0,
                    "lasttouch": 1519281311,
                    "subject": {
                        "id": 174043,
                        "url": "http:\/\/bgm.tv\/subject\/174043",
                        "type": 2,
                        "name": "\u3053\u306e\u7d20\u6674\u3089\u3057\u3044\u4e16\u754c\u306b\u795d\u798f\u3092\uff012",
                        "name_cn": "\u4e3a\u7f8e\u597d\u7684\u4e16\u754c\u732e\u4e0a\u795d\u798f\uff01 \u7b2c\u4e8c\u5b63",
                        "summary": "",
                        "eps": 10,
                        "eps_count": 10,
                        "air_date": "2017-01-11",
                        "air_weekday": 3,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/53\/e6\/174043_Mt8Xb.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/53\/e6\/174043_Mt8Xb.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/53\/e6\/174043_Mt8Xb.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/53\/e6\/174043_Mt8Xb.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/53\/e6\/174043_Mt8Xb.jpg"
                        },
                        "collection": {
                            "doing": 341
                        }
                    }
                },
                {
                    "name": "\u30ea\u30c8\u30eb\u30a6\u30a3\u30c3\u30c1\u30a2\u30ab\u30c7\u30df\u30a2",
                    "subject_id": 185792,
                    "ep_status": 13,
                    "vol_status": 0,
                    "lasttouch": 1519281280,
                    "subject": {
                        "id": 185792,
                        "url": "http:\/\/bgm.tv\/subject\/185792",
                        "type": 2,
                        "name": "\u30ea\u30c8\u30eb\u30a6\u30a3\u30c3\u30c1\u30a2\u30ab\u30c7\u30df\u30a2",
                        "name_cn": "\u5c0f\u9b54\u5973\u5b66\u56ed",
                        "summary": "",
                        "eps": 25,
                        "eps_count": 25,
                        "air_date": "2017-01-08",
                        "air_weekday": 7,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/c5\/09\/185792_YmcaM.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/c5\/09\/185792_YmcaM.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/c5\/09\/185792_YmcaM.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/c5\/09\/185792_YmcaM.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/c5\/09\/185792_YmcaM.jpg"
                        },
                        "collection": {
                            "doing": 796
                        }
                    }
                },
                {
                    "name": "\u30e1\u30a4\u30c9\u30a4\u30f3\u30a2\u30d3\u30b9",
                    "subject_id": 203526,
                    "ep_status": 1,
                    "vol_status": 0,
                    "lasttouch": 1519281263,
                    "subject": {
                        "id": 203526,
                        "url": "http:\/\/bgm.tv\/subject\/203526",
                        "type": 2,
                        "name": "\u30e1\u30a4\u30c9\u30a4\u30f3\u30a2\u30d3\u30b9",
                        "name_cn": "\u6765\u81ea\u6df1\u6e0a",
                        "summary": "",
                        "eps": 13,
                        "eps_count": 13,
                        "air_date": "2017-07-07",
                        "air_weekday": 5,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/f7\/bf\/203526_Mn88c.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/f7\/bf\/203526_Mn88c.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/f7\/bf\/203526_Mn88c.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/f7\/bf\/203526_Mn88c.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/f7\/bf\/203526_Mn88c.jpg"
                        },
                        "collection": {
                            "doing": 672
                        }
                    }
                },
                {
                    "name": "\u30af\u30d3\u30ad\u30ea\u30b5\u30a4\u30af\u30eb \u9752\u8272\u30b5\u30f4\u30a1\u30f3\u3068\u622f\u8a00\u9063\u3044",
                    "subject_id": 181880,
                    "ep_status": 4,
                    "vol_status": 0,
                    "lasttouch": 1519280734,
                    "subject": {
                        "id": 181880,
                        "url": "http:\/\/bgm.tv\/subject\/181880",
                        "type": 2,
                        "name": "\u30af\u30d3\u30ad\u30ea\u30b5\u30a4\u30af\u30eb \u9752\u8272\u30b5\u30f4\u30a1\u30f3\u3068\u622f\u8a00\u9063\u3044",
                        "name_cn": "\u65a9\u9996\u5faa\u73af \u84dd\u8272\u5b66\u8005\u4e0e\u620f\u8a00\u8ddf\u73ed",
                        "summary": "",
                        "eps": 8,
                        "eps_count": 8,
                        "air_date": "2016-10-26",
                        "air_weekday": 3,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/b6\/79\/181880_mnV17.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/b6\/79\/181880_mnV17.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/b6\/79\/181880_mnV17.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/b6\/79\/181880_mnV17.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/b6\/79\/181880_mnV17.jpg"
                        },
                        "collection": {
                            "doing": 199
                        }
                    }
                },
                {
                    "name": "\u3042\u3093\u30cf\u30d4\u266a",
                    "subject_id": 138053,
                    "ep_status": 6,
                    "vol_status": 0,
                    "lasttouch": 1519280731,
                    "subject": {
                        "id": 138053,
                        "url": "http:\/\/bgm.tv\/subject\/138053",
                        "type": 2,
                        "name": "\u3042\u3093\u30cf\u30d4\u266a",
                        "name_cn": "Anne Happy\u266a",
                        "summary": "",
                        "eps": 12,
                        "eps_count": 12,
                        "air_date": "2016-04-07",
                        "air_weekday": 4,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/e4\/51\/138053_IKcmK.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/e4\/51\/138053_IKcmK.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/e4\/51\/138053_IKcmK.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/e4\/51\/138053_IKcmK.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/e4\/51\/138053_IKcmK.jpg"
                        },
                        "collection": {
                            "doing": 130
                        }
                    }
                },
                {
                    "name": "NEW GAME!",
                    "subject_id": 150775,
                    "ep_status": 6,
                    "vol_status": 0,
                    "lasttouch": 1519280608,
                    "subject": {
                        "id": 150775,
                        "url": "http:\/\/bgm.tv\/subject\/150775",
                        "type": 2,
                        "name": "NEW GAME!",
                        "name_cn": "",
                        "summary": "",
                        "eps": 13,
                        "eps_count": 13,
                        "air_date": "2016-07-04",
                        "air_weekday": 1,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/0f\/79\/150775_rRSAT.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/0f\/79\/150775_rRSAT.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/0f\/79\/150775_rRSAT.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/0f\/79\/150775_rRSAT.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/0f\/79\/150775_rRSAT.jpg"
                        },
                        "collection": {
                            "doing": 424
                        }
                    }
                },
                {
                    "name": "\u3089\u304d\u2606\u3059\u305f",
                    "subject_id": 276,
                    "ep_status": 12,
                    "vol_status": 0,
                    "lasttouch": 1519229609,
                    "subject": {
                        "id": 276,
                        "url": "http:\/\/bgm.tv\/subject\/276",
                        "type": 2,
                        "name": "\u3089\u304d\u2606\u3059\u305f",
                        "name_cn": "\u5e78\u8fd0\u661f",
                        "summary": "",
                        "eps": 24,
                        "eps_count": 24,
                        "air_date": "2007-04-08",
                        "air_weekday": 7,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/db\/8e\/276_ad2eA.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/db\/8e\/276_ad2eA.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/db\/8e\/276_ad2eA.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/db\/8e\/276_ad2eA.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/db\/8e\/276_ad2eA.jpg"
                        },
                        "collection": {
                            "doing": 537
                        }
                    }
                },
                {
                    "name": "\u8ce2\u8005\u306e\u5f1f\u5b50\u3092\u540d\u4e57\u308b\u8ce2\u8005",
                    "subject_id": 134684,
                    "ep_status": 0,
                    "vol_status": 2,
                    "lasttouch": 1616040691,
                    "subject": {
                        "id": 134684,
                        "url": "http:\/\/bgm.tv\/subject\/134684",
                        "type": 1,
                        "name": "\u8ce2\u8005\u306e\u5f1f\u5b50\u3092\u540d\u4e57\u308b\u8ce2\u8005",
                        "name_cn": "\u81ea\u79f0\u8d24\u8005\u5f1f\u5b50\u7684\u8d24\u8005",
                        "summary": "",
                        "vols_count": 10,
                        "air_date": "0000-00-00",
                        "air_weekday": 2,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/9e\/af\/134684_5cR7Z.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/9e\/af\/134684_5cR7Z.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/9e\/af\/134684_5cR7Z.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/9e\/af\/134684_5cR7Z.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/9e\/af\/134684_5cR7Z.jpg"
                        },
                        "collection": {
                            "doing": 33
                        }
                    }
                },
                {
                    "name": "\u30c6\u30a3\u30a2\u30e0\u30fc\u30f3\u5e1d\u56fd\u7269\u8a9e ~\u65ad\u982d\u53f0\u304b\u3089\u59cb\u307e\u308b\u3001\u59eb\u306e\u8ee2\u751f\u9006\u8ee2\u30b9\u30c8\u30fc\u30ea\u30fc~",
                    "subject_id": 305872,
                    "ep_status": 0,
                    "vol_status": 1,
                    "lasttouch": 1615471920,
                    "subject": {
                        "id": 305872,
                        "url": "http:\/\/bgm.tv\/subject\/305872",
                        "type": 1,
                        "name": "\u30c6\u30a3\u30a2\u30e0\u30fc\u30f3\u5e1d\u56fd\u7269\u8a9e ~\u65ad\u982d\u53f0\u304b\u3089\u59cb\u307e\u308b\u3001\u59eb\u306e\u8ee2\u751f\u9006\u8ee2\u30b9\u30c8\u30fc\u30ea\u30fc~",
                        "name_cn": "\u4e9a\u7a46\u5e1d\u56fd\u7269\u8bed(01)~\u4ece\u65ad\u5934\u53f0\u5f00\u59cb\uff0c\u516c\u4e3b\u91cd\u751f\u540e\u7684\u9006\u8f6c\u4eba\u751f~",
                        "summary": "",
                        "vols_count": 7,
                        "air_date": "2019-06-10",
                        "air_weekday": 1,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/5d\/58\/305872_mVwvR.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/5d\/58\/305872_mVwvR.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/5d\/58\/305872_mVwvR.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/5d\/58\/305872_mVwvR.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/5d\/58\/305872_mVwvR.jpg"
                        },
                        "collection": {
                            "doing": 6
                        }
                    }
                },
                {
                    "name": "百合に挟まれてる女って、罪ですか？",
                    "subject_id": 316863,
                    "ep_status": 0,
                    "vol_status": 0,
                    "lasttouch": 1615471799,
                    "subject": {
                        "id": 316863,
                        "url": "http:\/\/bgm.tv\/subject\/316863",
                        "type": 1,
                        "name": "百合に挟まれてる女って、罪ですか？",
                        "name_cn": "\u5939\u5728\u767e\u5408\u4e2d\u95f4\u7684\u5973\u4eba\uff0c\u6709\u7f6a\u5417\uff1f",
                        "summary": "",
                        "air_date": "2020-11-10",
                        "air_weekday": 2,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/79\/1f\/316863_K9dnt.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/79\/1f\/316863_K9dnt.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/79\/1f\/316863_K9dnt.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/79\/1f\/316863_K9dnt.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/79\/1f\/316863_K9dnt.jpg"
                        },
                        "collection": {
                            "doing": 4
                        }
                    }
                },
                {
                    "name": "\u5973\u540c\u58eb\u3068\u304b\u3042\u308a\u3048\u306a\u3044\u3067\u3057\u3087\u3068\u8a00\u3044\u5f35\u308b\u5973\u306e\u5b50\u3092\u3001\u767e\u65e5\u9593\u3067\u5fb9\u5e95\u7684\u306b\u843d\u3068\u3059\u767e\u5408\u306e\u304a\u8a71",
                    "subject_id": 261543,
                    "ep_status": 0,
                    "vol_status": 1,
                    "lasttouch": 1615471760,
                    "subject": {
                        "id": 261543,
                        "url": "http:\/\/bgm.tv\/subject\/261543",
                        "type": 1,
                        "name": "\u5973\u540c\u58eb\u3068\u304b\u3042\u308a\u3048\u306a\u3044\u3067\u3057\u3087\u3068\u8a00\u3044\u5f35\u308b\u5973\u306e\u5b50\u3092\u3001\u767e\u65e5\u9593\u3067\u5fb9\u5e95\u7684\u306b\u843d\u3068\u3059\u767e\u5408\u306e\u304a\u8a71",
                        "name_cn": "\u5c06\u653e\u8a00\u8bf4\u5973\u751f\u4e4b\u95f4\u4e0d\u53ef\u80fd\u7684\u5973\u5b69\u5b50\uff0c\u5728\u767e\u65e5\u4e4b\u5185\u5f7b\u5e95\u653b\u9677\u7684\u767e\u5408\u6545\u4e8b",
                        "summary": "",
                        "air_date": "0000-00-00",
                        "air_weekday": 2,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/ca\/8a\/261543_2KRhF.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/ca\/8a\/261543_2KRhF.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/ca\/8a\/261543_2KRhF.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/ca\/8a\/261543_2KRhF.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/ca\/8a\/261543_2KRhF.jpg"
                        },
                        "collection": {
                            "doing": 33
                        }
                    }
                },
                {
                    "name": "\u85ac\u5c4b\u306e\u3072\u3068\u308a\u3054\u3068",
                    "subject_id": 156126,
                    "ep_status": 0,
                    "vol_status": 3,
                    "lasttouch": 1615471579,
                    "subject": {
                        "id": 156126,
                        "url": "http:\/\/bgm.tv\/subject\/156126",
                        "type": 1,
                        "name": "\u85ac\u5c4b\u306e\u3072\u3068\u308a\u3054\u3068",
                        "name_cn": "\u836f\u5c4b\u5c11\u5973\u7684\u5462\u5583",
                        "summary": "",
                        "air_date": "2014-09-01",
                        "air_weekday": 1,
                        "images": {
                            "large": "http:\/\/lain.bgm.tv\/pic\/cover\/l\/02\/fa\/156126_6AjzZ.jpg",
                            "common": "http:\/\/lain.bgm.tv\/pic\/cover\/c\/02\/fa\/156126_6AjzZ.jpg",
                            "medium": "http:\/\/lain.bgm.tv\/pic\/cover\/m\/02\/fa\/156126_6AjzZ.jpg",
                            "small": "http:\/\/lain.bgm.tv\/pic\/cover\/s\/02\/fa\/156126_6AjzZ.jpg",
                            "grid": "http:\/\/lain.bgm.tv\/pic\/cover\/g\/02\/fa\/156126_6AjzZ.jpg"
                        },
                        "collection": {
                            "doing": 23
                        }
                    }
                }
            ]
        """.trimIndent())
        assertNotEquals(collectionJson.parseJson(), null)
    }
}