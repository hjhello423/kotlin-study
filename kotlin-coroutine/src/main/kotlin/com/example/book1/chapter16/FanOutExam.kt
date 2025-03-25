package com.example.book1.chapter16

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {

    repeat(10) {
        delay(100)
        send(it)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>): Job = launch {
    for (msg in channel) {
        println("Processor $id received $msg")
    }
}

suspend fun main(): Unit = coroutineScope {
    val channel = produceNumbers()
    repeat(3) { it ->
        delay(10)
        launchProcessor(it, channel)
    }
}
