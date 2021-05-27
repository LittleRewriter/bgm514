package com.lire.baseappearance

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lire.netdatahandler.SearchJsonHandler
import com.lire.netdatahandler.searchJsonSample

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
        val searchJson = SearchJsonHandler(searchJsonSample)
        searchJson.parseJson()
    }
}