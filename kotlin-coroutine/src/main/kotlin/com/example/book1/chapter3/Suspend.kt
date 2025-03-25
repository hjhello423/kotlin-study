package com.example.book1.chapter3

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
        println("before sleep")
        Thread.sleep(3000)
        continuation.resume(Unit)
        println("after resume")
    }
}

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> { continuation ->
        println("in lambda")
        continueAgerSecond(continuation)
    }

    println("After")
}
