package com.example.chapter3

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun returnTypeMain1() {
    val i: Int = suspendCoroutine<Int> { continuation ->
        continuation.resume(1)
    }
    println(i)

    val str: String = suspendCoroutine<String> { continuation ->
        continuation.resume("Hello")
    }
    println(str)

    val b: Boolean = suspendCoroutine<Boolean> { continuation ->
        continuation.resume(true)
    }
    println(b)
}

suspend fun returnTypeMain2() {
    println("Before")
    val user = suspendCoroutine<User> { continuation ->
        requestUser { user -> continuation.resume(user) }
    }

    println(user)
    println("After")
}

suspend fun requestUser(): User {
    return suspendCoroutine<User> { continuation ->
        requestUser { user -> continuation.resume(user) }
    }
}

suspend fun main() {
    println("Before")
    val user = requestUser()

    println(user)
    println("After")
}

fun requestUser(callback: (User) -> Unit) {
    Thread.sleep(1000)
    callback(User("홍길동"))
}
