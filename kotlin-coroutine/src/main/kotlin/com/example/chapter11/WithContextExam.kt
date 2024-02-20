package com.example.chapter11

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun CoroutineScope.log(msg: String) {
    val name = this.coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main() = runBlocking(CoroutineName("Parent")) {
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
