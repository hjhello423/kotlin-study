package com.example.chapter16

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope

// 1부터 3까지의 수를 가진 채널
fun CoroutineScope.numbers(): ReceiveChannel<Int> = produce {
    repeat(3) { num ->
        send(num + 1)
    }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>) = produce {
    for (num in numbers) {
        send(num * num)
    }
}

suspend fun main() = coroutineScope {
    val numbers = numbers()
    val squared = square(numbers)
    for (num in squared) {
        println(num)
    }
}
