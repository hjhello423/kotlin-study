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

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("Before too")
        continueAgerSecond(continuation)
    }

    println("After")
}
