package com.example.chapter17

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select

suspend fun requestData1(): String {
    delay(5_000)
    return "Data1"
}

suspend fun requestData2(): String {
    delay(1_000)
    return "Data2"
}

val scope = CoroutineScope(SupervisorJob())

suspend fun askMultipleForData(): String {
    val defData1 = scope.async { requestData1() }
    val defData2 = scope.async { requestData2() }
    return select {
        defData1.onAwait { it }
        defData2.onAwait { it }
    }
}

suspend fun main(): Unit = coroutineScope {
    println(askMultipleForData())
}
