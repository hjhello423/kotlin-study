package com.example.chapter3

import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MyException : IllegalArgumentException("My Exception")

suspend fun exceptionMain1() {
    try {
        suspendCoroutine<Unit> { continuation ->
            continuation.resumeWithException(MyException())
        }
    } catch (e: MyException) {
        println("Caught MyException")
    }
}
