package com.example.book1.chapter3


import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


private val executor =
    Executors.newSingleThreadScheduledExecutor { // ScheduledExecutorService
        Thread(it, "scheduler")
            .apply { isDaemon = true }
    }

suspend fun delay(timeMillis: Long): Unit =
    suspendCoroutine { continuation ->
        executor.schedule({
            continuation.resume(Unit)
        }, timeMillis, TimeUnit.MILLISECONDS)
    }

suspend fun main() {
    println("Before")

    delay(1000)

    println("After")
}
