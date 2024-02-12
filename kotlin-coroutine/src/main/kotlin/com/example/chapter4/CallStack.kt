package com.example.chapter4

import com.example.chapter3.User

suspend fun main() {
    a()
}

suspend fun a() {
    val user = readUser()
    b()
    println("b 1")
    b()
    println("b 2")
    b()
    println("b 3")
    println(user)
}

suspend fun b() {
    for (i in 1..10) {
        c(i)
    }
}

suspend fun c(i: Int) {
    delay(i * 100L)
    println("tick $i")
}

fun readUser(): User {
    return User("tom")
}
