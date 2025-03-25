package com.example.book1.chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}

fun main_builder1() = runBlocking(CoroutineName("myMain")) {
    log("started") // [myMain] started
    val v1 = async {
        delay(1000)
        log("running async") // [myMain] running async
        42
    }
    launch {
        delay(3000)
        log("running launch") // [myMain] running launch
    }
    log("the answer is ${v1.await()}") // [myMain] the answer is 42
}

fun main() = runBlocking(CoroutineName("myMain")) {
    log("started") // [myMain] started
    val v1 = async(CoroutineName("c1")) {
        delay(2000)
        log("running async") // [c1] running async
        42
    }
    launch(CoroutineName("c2")) {
        delay(3000)
        log("running launch") // [c2] running launch
    }
    log("the answer is ${v1.await()}") // [myMain] the answer is 42
    log("end")
}
