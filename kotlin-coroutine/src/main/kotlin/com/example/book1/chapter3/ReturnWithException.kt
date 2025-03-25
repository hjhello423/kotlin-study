package com.example.book1.chapter3

import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MyException : IllegalArgumentException("My Exception")

suspend fun main() {
    try {
        suspendCoroutine<Unit> { continuation ->
            continuation.resumeWithException(MyException())
        }
    } catch (e: MyException) {
        println("Caught MyException")
    }
}
