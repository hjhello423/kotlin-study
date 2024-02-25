package com.example.chapter12

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

suspend fun main(): Unit =
    withContext(newSingleThreadContext("Thread1")) {
        var continuation: Continuation<Unit>? = null

        launch(newSingleThreadContext("Thread2")) {
            println("test0 - ${Thread.currentThread().name}") // Thread2
            delay(1000)
            continuation?.resume(Unit)
            println("test1 - ${Thread.currentThread().name}") // Thread2
        }

        launch(Dispatchers.Unconfined) {
            println("test2 - ${Thread.currentThread().name}") // Thread1

            suspendCancellableCoroutine<Unit> {
                continuation = it
            }

            println("test3 - ${Thread.currentThread().name}") // Thread2

            delay(1000)

            println("test4 - ${Thread.currentThread().name}") // kotlinx.coroutines.DefaultExecutor - (delay가 사용한 스레드)
        }
    }
