package com.example.chapter6

import kotlinx.coroutines.*

fun main_async1() = runBlocking {
    val resultDeferred: Deferred<Int> = GlobalScope.async {
        delay(1000L)
        42
    }
    loop() // 다른 작업
    println()
    val result: Int = resultDeferred.await() // 42
    println(result)
    println(resultDeferred.await())  // 42
}

fun loop() {
    for (i in 1..10) {
        Thread.sleep(200L)
        print("$i, ")
    }
}

fun main() = runBlocking {
    val res1 = GlobalScope.async {
        delay(1000L)
        "text 1"
    }
    val res2 = GlobalScope.async {
        delay(3000L)
        "text 2"
    }
    val res3 = GlobalScope.async {
        delay(2000L)
        "text 3"
    }
    println(res1.await())
    println(res2.await())
    println(res3.await())
}
