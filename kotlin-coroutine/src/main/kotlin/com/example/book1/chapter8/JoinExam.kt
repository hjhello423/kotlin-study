package com.example.book1.chapter8

import kotlinx.coroutines.*

fun main_job1(): Unit = runBlocking {
    val name = CoroutineName("name1")
    val job = Job()

    launch(name + job) {
        val childName = coroutineContext[CoroutineName]
        println(childName == name) // true

        val childJob = coroutineContext[Job]
        println(childJob == job) // false
        println(childJob == job.children.first()) // true
    }
}

fun main_join1(): Unit = runBlocking {
    val job1 = launch {
        delay(2000)
        println("job1")
    }

    val job2 = launch {
        delay(4000)
        println("job2")
    }

    job1.join()
    job2.join()
    println("done")
}

fun main(): Unit = runBlocking {
    launch {
        delay(1000)
        println("test 1")
    }

    launch {
        delay(2000)
        println("test 2")
    }

    val children = coroutineContext[Job]
        ?.children

    val childrenNum = children?.count()
    println("number of children: $childrenNum")
    children?.forEach {
        it.join()
    }
    println("all test are done")
}
