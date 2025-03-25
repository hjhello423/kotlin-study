package com.example.book1.chapter17

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

suspend fun CoroutineScope.produceString(
    s: String,
    time: Long
): ReceiveChannel<String> = produce {
    while (true) {
        delay(time)
        send(s)
    }
}

fun main(): Unit = runBlocking {
    val fooChannel: ReceiveChannel<String> = produceString("foo", 1000L)
    val barChannel: ReceiveChannel<String> = produceString("BAR", 3000L)

    repeat(7) {
        select { // 채널에 select 사용
            fooChannel.onReceive {
                println("From fooChannel: $it")  // 받은 값을 람다식의 인자로 사용
            }
            barChannel.onReceive {
                println("From barChannel: $it")
            }
        }
    }

    coroutineContext.cancelChildren()
}
