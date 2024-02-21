package com.example.chapter8

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(2000)
        println("job1")
    }

    val job2 = launch {
        delay(4000)
        println("job2")
    }

    job1.join()
    job2.join()
    println("done")
}
