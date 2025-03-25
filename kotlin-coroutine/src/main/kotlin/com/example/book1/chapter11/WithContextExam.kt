package com.example.book1.chapter11

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun CoroutineScope.log(msg: String) {
    val name = this.coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main1() = runBlocking(CoroutineName("Parent")) {
    log("before")

    withContext(CoroutineName("Child 1")) {
        delay(1000)
        log("hello 1")
    }

    withContext(CoroutineName("Child 2")) {
        delay(1000)
        log("hello 2")
    }

    log("after")
}

fun main() {
    repeat(100_000) {
        thread {
            Thread.sleep(1000)
            print(".")
        }
    }
    println("done")
}
