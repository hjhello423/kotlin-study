package com.example.chapter17

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

fun main(): Unit = runBlocking {
    val c1: Channel<Char> = Channel<Char>(capacity = 2)
    val c2: Channel<Char> = Channel<Char>(capacity = 2)

    launch {
        for (c in 'A'..'H') {
            delay(400)
            select<Unit> { // onSend는 Unit을 반환한다.
                c1.onSend(c) { println("sent #1 - $c") }
                c2.onSend(c) { println("sent #2 - $c") }
            }
        }
    }

    launch {
        while (true) {
            delay(1000)
            val c: String = select<String> {
                c1.onReceive { "$it from #1" }
                c2.onReceive { "$it from #2" }
            }
            println("received $c")
        }
    }
}
