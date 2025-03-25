package com.example.book1.chapter10

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object MyNonPropagatingException : CancellationException()

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(2000)
            println("will not be printed")
        }
        throw MyNonPropagatingException
    }
    launch {
        delay(2000)
        println("will be printed")
    }
}
