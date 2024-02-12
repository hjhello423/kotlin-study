package com.example.chapter4

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//suspend fun myFunction(token: String) {
//    println("Before")
//    val userId = getUserId(token) // 중단 함수
//    println("userId: $userId")
//    val userName = getUserName(userId, token) // 중단 함수
//    println("userName: $userName")
//    println("After")
//}

suspend fun delay(timeMillis: Long) {
    suspendCoroutine<Unit> { continuation ->
        executor.schedule({
            continuation.resume(Unit)
        }, timeMillis, TimeUnit.MILLISECONDS)
    }
}

private val executor =
    Executors.newSingleThreadScheduledExecutor {
        Thread(it, "scheduler")
            .apply { isDaemon = true }
    }

//fun printUser(token: String, continuation: Continuation<*>): Any {
//    val continuation = continuation as? PrintUserContinuation
//        ?: PrintUserContinuation(continuation as Continuation<Unit>, token)
//
//    var result: Result<Any>? = continuation.result
//    var userId: String? = continuation.userId
//    val userName = String
//
//    if (continuation.label == 0) {
//        println("Before")
//        continuation.label = 1
//        val res = getUserId(token, continuation)
//        if (res == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//        result = Result.success(res)
//    }
//    if (continuation.label == 1) {
//        userId = result!!.getOrThrow() as String
//        println("userId: $userId")
//        continuation.label = 2
//        continuation.userId = userId
//        val res = getUserName(userId, token, continuation)
//        if (res == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//        result = Result.success(res)
//    }
//    if (continuation.label == 2) {
//        userName = result!!.getOrThrow() as String
//        println(User(userId as String, userName))
//        println("After")
//        return Unit
//    }
//    error("Impossible")
//}

//fun myFunction(continuation: Continuation<Unit>): Any {
//    val continuation = continuation as? MyFunctionContinuation
//        ?: MyFunctionContinuation(continuation)
//
//    var counter = continuation.counter // 지역변수 저장
//
//    if (continuation.label == 0) { // 처음 호출
//        println("Before")
//        counter = 0
//        continuation.counter = counter
//        continuation.label = 1 // 다음 상태로 세팅
//        if (delay(1000, continuation)) == COROUTINE_SUSPENDED) {
//            return COROUTINE_SUSPENDED
//        }
//    }
//    if (continuation.label == 1) {
//        counter = (counter as Int) + 1
//        println("counter: $counter")
//        println("After")
//        return Unit
//    }
//    error("Impossible")
//}


val COROUTINE_SUSPENDED = Any()
