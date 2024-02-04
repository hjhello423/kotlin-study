package com.example.chapter3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun suspendMain1() {
    println("Before")

    suspendCoroutine<Unit> { }  // 중단지점

    println("After")
}

suspend fun suspendMain2() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("Before too")
    }

    println("After")
}

suspend fun suspendMain3() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("Before too")
        continuation.resume(Unit)
    }

    println("After")
}

fun continueAgerSecond(continuation: Continuation<Unit>) {
    thread {
        Thread.sleep(1000)
        continuation.resume(Unit)
    }
}

suspend fun suspendMain4() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("Before too")
        continueAgerSecond(continuation)
    }

    println("After")
}

private val executor =
    Executors.newSingleThreadScheduledExecutor {
        Thread(it, "scheduler")
            .apply { isDaemon = true }
    }

suspend fun suspendMain5() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("Before too")
        executor.schedule({
            continuation.resume(Unit)
        }, 1000, TimeUnit.MILLISECONDS)
    }

    println("After")
}


suspend fun delay(timeMillis: Long) {
    suspendCoroutine<Unit> { continuation ->
        executor.schedule({
            continuation.resume(Unit)
        }, timeMillis, TimeUnit.MILLISECONDS)
    }
}

suspend fun main() {
    println("Before")

    delay(1000)

    println("After")
}
