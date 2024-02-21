package com.example.chapter8

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main_1(): Unit = coroutineScope {
    val job = Job()

    launch(job) {
        delay(1000)
        println("1")
    }

    launch(job) {
        delay(2000)
        println("2")
    }

    job.join()
    println("will not be printed")
}

suspend fun main(): Unit = coroutineScope {
    val job = Job()

    launch(job) {
        delay(1000)
        println("1")
    }

    launch(job) {
        delay(2000)
        println("2")
    }

    job.children.forEach { it.join() }
}
