package com.example.book1.chapter6

import com.example.book1.chapter4.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    this.launch {
        delay(1000L)
        println("World!")
    }
    launch {
        delay(2000L)
        println("World!")
    }
    println("Hello,")
}
