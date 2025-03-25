package com.example.book1.chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

suspend fun printName() {
    println(coroutineContext[CoroutineName]?.name)
}

suspend fun main() = withContext(CoroutineName("outher")) {
    printName() // outher
    launch(CoroutineName("inner")) {
        printName() // inner
    }
    delay(10)
    printName() // outher
}
