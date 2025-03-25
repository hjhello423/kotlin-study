package com.example.book1.chapter8

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = Job()
    println(job)
    job.complete()
    println(job)

    val activeJob = launch {
        delay(1000)
    }
    println(activeJob)
    activeJob.join()
    println(activeJob)

    val lazyJob = launch(start = CoroutineStart.LAZY) {
        delay(1000)
    }
}
