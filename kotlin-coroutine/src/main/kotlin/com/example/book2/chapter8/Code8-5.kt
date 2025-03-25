package com.example.book2.chapter8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // supervisorJob의 parent로 runBlocking으로 생성된 Job 객체 설정
    val supervisorJob = SupervisorJob(parent = this.coroutineContext[Job]) // 부모와 구조화
    launch(CoroutineName("Coroutine1") + supervisorJob) {
        launch(CoroutineName("Coroutine3")) {
            throw Exception("예외 발생")
        }
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    launch(CoroutineName("Coroutine2") + supervisorJob) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    supervisorJob.complete() // supervisorJob 완료 처리
}
