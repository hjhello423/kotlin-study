package com.example.book1.chapter19

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import java.io.File
import java.math.BigInteger

val fibonacci: Sequence<BigInteger> = sequence {
    var first: BigInteger = 0.toBigInteger()
    var second: BigInteger = 1.toBigInteger()
    while (true) {
        yield(first)
        val temp: BigInteger = first
        first += second
        second = temp
    }
}

fun countCharactersInFile(path: String): Int =
    File(path).useLines { lines ->
        return lines.sumBy { it.length }
    }

fun getSequence2(): Sequence<String> = sequence {
    repeat(3) {
        Thread.sleep(1000)
        yield("User$it")
    }
}

suspend fun main() {
    withContext(newSingleThreadContext("main")) {
        launch {
            repeat(3) {
                delay(100)
                println("Processing on coroutine")
            }
        }

        val list: Sequence<String> = getSequence2()
        list.forEach { println(it) } // 블로킹 연산
    }
}


