package com.example.chapter12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() = coroutineScope {
    repeat(1000) {
        launch(Dispatchers.Default) {
            List(1000) {
                Random.nextLong()
            }.maxOrNull()

            val threadName = Thread.currentThread().name
            println("running on thread: $threadName")
        }
    }
}
