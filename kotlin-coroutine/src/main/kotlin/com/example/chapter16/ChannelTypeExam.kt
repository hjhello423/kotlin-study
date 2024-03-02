package com.example.chapter16

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main(): Unit = coroutineScope {
    val channel = produce(capacity = 3) { // 버퍼 용량을 3으로 설정
        repeat(5) { index ->
            val element = index * 2
            send(element)
            delay(100)
            println("produce $element")
        }
    }

    delay(1000)

    for (element in channel) {
        println(element)
        delay(1000)
    }
}
