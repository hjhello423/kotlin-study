package com.example.book1.chapter10

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main1(): Unit = runBlocking {
    val scope = CoroutineScope(SupervisorJob())
    scope.launch {
        delay(1000)
        throw Error("error")
    }

    scope.launch {
        delay(2000)
        println("will be printed")
    }

    delay(3000)
}

fun main(): Unit = runBlocking {
    val job = SupervisorJob()

    launch(job) {
        delay(1000)
        throw Error("error")
    }

    launch(job) {
        delay(2000)
        println("will be printed")
    }

    delay(3000)
}
