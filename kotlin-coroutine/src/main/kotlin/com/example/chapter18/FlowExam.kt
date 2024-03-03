package com.example.chapter18

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

private fun CoroutineScope.makeChannel() = produce {
    println("Channel started")
    for (i in 1..3) {
        delay(1000)
        send(i)
    }
}

//suspend fun main_hotChannel() = coroutineScope {
suspend fun main() = coroutineScope {
    val channel = makeChannel()

    delay(1000)
    println("Calling channel...")
    for (value in channel) {
        println(value)
    }
    println("Consuming again...")
    for (value in channel) {
        println(value)
    }
}


private fun makeFlow() = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

//suspend fun main() = coroutineScope {
//    val flow = makeFlow()
//
//    delay(1000)
//    println("Calling flow...")
//    flow.collect { value -> println(value) }
//    println("Consuming again...")
//    flow.collect { value -> println(value) }
//}
