package com.lire.baseappearance

import com.lire.netdatahandler.CalendarJsonHandler
import com.lire.netdatahandler.testJson
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun TestCorrectParsingCalendar() {
        val json = CalendarJsonHandler(testJson)
        json.parseJson()
    }
}