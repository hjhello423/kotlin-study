package com.example.book1.chapter3

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main_returnType1() {
    val i: Int = suspendCoroutine<Int> { continuation -> //  Int
        continuation.resume(1) //  Int 반환
    }
    println(i)

    val str: String = suspendCoroutine<String> { continuation -> // String
        continuation.resume("Hello") // String 반환
    }
    println(str)

    val b: Boolean = suspendCoroutine<Boolean> { continuation -> // Boolean
        continuation.resume(true) // Boolean 반환
    }
    println(b)
}

suspend fun main2() {
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
