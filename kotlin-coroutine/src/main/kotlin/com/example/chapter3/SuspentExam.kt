package com.example.chapter3

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

var continuation: Continuation<Unit>? = null

suspend fun suspendAndSetContinuation() {
    suspendCoroutine<Unit> { cont ->
        continuation = cont // set 한 뒤에 중단된다.
    }
}

suspend fun main_suspend1() {
    println("Before")

    suspendAndSetContinuation()
    continuation?.resume(Unit) // 호출 안됨

    println("After")
}

suspend fun main() = coroutineScope {
    println("Before")

    launch {
        delay(1000)
        continuation?.resume(Unit) // 호출됨
    }

    suspendAndSetContinuation()
    println("After")
}
