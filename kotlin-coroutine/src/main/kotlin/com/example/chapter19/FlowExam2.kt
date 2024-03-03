package com.example.chapter19

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

fun usersFlow(): Flow<String> = flow { // CoroutineScope가 필요하지 않다.
    repeat(3) {
        delay(1000)
        val ctx: CoroutineContext = currentCoroutineContext()
        val name: String? = ctx[CoroutineName]?.name
        emit("User$it in $name")
    }
}

suspend fun main() {
    val users: Flow<String> = usersFlow()

    withContext(CoroutineName("Name")) {
        val job: Job = launch {
            users.collect { println(it) } // 최종 연산
        }

        launch {
            delay(2100)
            println("I got enough")
            job.cancel() // flow 취소
        }
    }
}
