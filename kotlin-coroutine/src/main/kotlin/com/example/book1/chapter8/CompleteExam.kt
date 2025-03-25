package com.example.book1.chapter8

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = Job()

    launch(job) {
        repeat(7) { num ->
            delay(200)
            println("rep $num")
        }
    }

    launch {
        delay(500)
        job.complete()
    }

    job.join()

    launch(job) {
        println("will not be printed") // complete를 호출한 job에서 코루틴이 시작될 수는 없다.
    }

    println("done")
}
