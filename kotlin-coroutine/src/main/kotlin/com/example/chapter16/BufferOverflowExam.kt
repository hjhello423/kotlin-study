package com.example.chapter16

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val channel = Channel<Int>(
        capacity = 2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    launch {
        repeat(5) {
            channel.send(it)
            println("produce: $it")
            delay(1000)
        }
        channel.close()
    }

    delay(4000)
    println("---------------- after 4000 ----------------")

    for (element in channel) {
        println("received: $element")
        delay(1000)
    }
}
