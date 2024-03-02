package com.example.chapter16

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main_Buffered(): Unit = coroutineScope {
    val channel = produce(capacity = 3) { // 버퍼 용량을 3으로 설정
        repeat(5) { index ->
            send(index)
            println("produce: $index")
            delay(1000)
        }
    }

    delay(5000)
    println("---------------- after 5000 ----------------")

    for (element in channel) {
        println("received: $element")
        delay(1000)
    }
}

suspend fun main_rendezvous(): Unit = coroutineScope {
    val channel = produce(capacity = Channel.RENDEZVOUS) { // 버퍼 용량을 0으로 설정 , default
        repeat(5) { index ->
            send(index)
            println("produce: $index")
            delay(1000)
        }
    }

    delay(5000)
    println("---------------- after 5000 ----------------")

    for (element in channel) {
        println("received: $element")
        delay(1000)
    }
}

suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = Channel.CONFLATED) { // 버퍼 용량을 1으로 설정
        repeat(5) { index ->
            send(index)
            println("produce: $index")
            delay(1000)
        }
    }

    delay(4000)
    println("---------------- after 4000 ----------------")

    for (element in channel) {
        println("received: $element")
        delay(1000)
    }
}
