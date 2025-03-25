package com.example.book1.chapter19

fun getList(): List<String> = List(3) {
    Thread.sleep(1000)
    "User$it"
}

fun main_list() {
    val list: List<String> = getList()
    println("function started")
    list.forEach { println(it) }
}

fun getSequence(): Sequence<String> = sequence {
    repeat(3) {
        Thread.sleep(1000)
        yield("User$it")
    }
}

fun main() {
    val list: Sequence<String> = getSequence()
    println("function started")
    list.forEach { println(it) }
}
