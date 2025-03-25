package com.example.book1.chapter16

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main_basic1(): Unit = coroutineScope {
    val channel: Channel<Int> = Channel<Int>() // 원소의 type은 Int
    launch {
        repeat(5) {
            delay(1000)
            println("produce next")
            channel.send(it * 2)
        }
    }

    launch {
        repeat(5) {
            val received = channel.receive()
            println("receive: ${received}")
        }
    }
}

suspend fun main(): Unit = coroutineScope {
    val channel: ReceiveChannel<Int> = produce { // ReceiveChannel을 반환
        repeat(5) { index ->
            println("produce next")
            delay(1000)
            send(index * 2)
        }
    }

    for (element in channel) {
        println(element)
    }
}
