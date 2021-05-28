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
//        assertNotEquals(collectionJson.parseJson(), null)
    }
}