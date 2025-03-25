package com.example.book1.chapter8

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = Job()

    launch(job) {
        repeat(5) { num ->
            delay(200)
            println("rep $num")
        }
    }

    launch {
        delay(500)
        job.completeExceptionally(Exception("error"))
    }

    job.join()

    launch(job) {
        println("will not be printed") // 위에서 취소 됨
    }

    println("done")
}
