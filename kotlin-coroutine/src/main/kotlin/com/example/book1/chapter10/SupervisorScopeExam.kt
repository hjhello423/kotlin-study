package com.example.book1.chapter10

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope


fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            delay(1000)
            throw Error("error")
        }

        launch {
            delay(2000)
            println("will be printed")
        }
    }

    delay(1000)
    println("done")
}
