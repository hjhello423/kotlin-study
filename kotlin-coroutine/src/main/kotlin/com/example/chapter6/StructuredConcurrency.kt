package com.example.chapter6

import com.example.chapter4.delay
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
