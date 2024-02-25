package com.example.chapter8

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main_1(): Unit = coroutineScope {
    val job = Job()

    launch(job) { // 새로운 job이 부모로부터 상속받은 job을 대체한다.
        delay(1000)
        println("1")
    }

    launch(job) { // 새로운 job이 부모로부터 상속받은 job을 대체한다.
        delay(2000)
        println("2")
    }

    job.join() // 여기서 영원히 대기한다.
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
