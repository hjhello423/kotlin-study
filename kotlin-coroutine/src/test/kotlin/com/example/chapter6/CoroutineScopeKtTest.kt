package com.example.chapter6

import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import java.time.Instant
import kotlin.test.Test

class CoroutineScopeKtTest {

    @Test
    fun test() = runTest {
        val currentTimeMs = Instant.now().toEpochMilli()
        delay(5000) // delay를 무시
        println("Done runTest : ${Instant.now().toEpochMilli() - currentTimeMs}ms")
    }


    @Test
    fun testMyCoroutine() = runTest {
        val result = myCoroutineFunction() // CoroutineScope 내에서 코루틴을 실행

        assertEquals(10, result)
    }

    // 테스트할 코루틴 함수
    suspend fun myCoroutineFunction(): Int {
        delay(5000) // 1초 동안 대기
        return 10
    }
}
