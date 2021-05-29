package com.lire.utils

import android.util.Log
import kotlin.coroutines.CoroutineContext

/**
 * 协程的打印辅助函数
 *
 */

fun logCoroutine(methodName: String, coroutineContext: CoroutineContext) {
    Log.e(
        "TestCoroutine", "Thread for $methodName is: ${Thread.currentThread().name}" +
                "and the context is $coroutineContext"
    )
}

fun logCoroutineThreadNameOnly(methodName: String) {
    Log.e(
        "TestCoroutine", "Thread for $methodName is: ${Thread.currentThread().name}"
    )
}