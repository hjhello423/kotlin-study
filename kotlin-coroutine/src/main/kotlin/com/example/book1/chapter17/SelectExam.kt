package com.example.book1.chapter17

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select
import kotlin.coroutines.coroutineContext

suspend fun requestData1(): String {
    delay(5_000)
    return "Data1"
}

suspend fun requestData2(): String {
    delay(1_000)
    return "Data2"
}

val scope: CoroutineScope = CoroutineScope(SupervisorJob())

suspend fun askMultipleForData(): String {
    val defData1: Deferred<String> = scope.async { requestData1() } // 비동기 프로세스 실행, Deferred 반환
    val defData2: Deferred<String> = scope.async { requestData2() } // 비동기 프로세스 실행
    return select { // 결과 1개만 반환
        defData1.onAwait { it }
        defData2.onAwait { it }
    }.also {
        coroutineContext.cancelChildren() // 코루틴 자식 취소
    }
}

suspend fun main(): Unit = coroutineScope {
    println(askMultipleForData())
}
