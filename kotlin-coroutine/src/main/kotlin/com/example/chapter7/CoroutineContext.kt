package com.example.chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun main_context() {
    val name: CoroutineName = CoroutineName("A name")
    val element: CoroutineContext.Element = name
    val context: CoroutineContext = element

    val job: Job = Job()
    val jobElement: CoroutineContext.Element = job
    val jobContext: CoroutineContext = jobElement
}

fun main_find() {
    val ctx: CoroutineContext = CoroutineName("A name")

    val coroutineName: CoroutineName? = ctx[CoroutineName]
    println(coroutineName?.name)

    val job: Job? = ctx[Job]
    println(job)
}

fun main_add() {
    val ctx1: CoroutineContext = CoroutineName("name1")
    println(ctx1[CoroutineName]?.name) // name1
    println(ctx1[Job]?.isActive) // null

    val ctx2: CoroutineContext = Job()
    println(ctx2[CoroutineName]?.name) // null
    println(ctx2[Job]?.isActive) // true

    val ctx3: CoroutineContext = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name) // name1
    println(ctx3[Job]?.isActive) // true

    val ctx1_2: CoroutineContext = CoroutineName("name1-2")
    val ctx4 = ctx1 + ctx1_2
    val ctx5 = ctx1_2 + ctx1
    println(ctx4[CoroutineName]?.name) // name1-2
    println(ctx5[CoroutineName]?.name) // name1
}

fun main_empty() {
    val empty: CoroutineContext = EmptyCoroutineContext
    println(empty[CoroutineName]) // null
    println(empty[Job]) // null

    val ctxName = empty + CoroutineName("name") + empty
    println(ctxName[CoroutineName]?.name) // name
}

fun main_remove() {
    val ctx = CoroutineName("name1") + Job()
    println(ctx[CoroutineName]?.name) // name1
    println(ctx[Job]?.isActive) // true

    val ctx2 = ctx.minusKey(CoroutineName)
    println(ctx2[CoroutineName]) // null
    println(ctx2[Job]?.isActive) // true

    val ctx3 = (ctx + CoroutineName("name2"))
        .minusKey(CoroutineName)
    println(ctx3[CoroutineName]?.name) // null
    println(ctx3[Job]?.isActive) // true
}

fun main() {
    val ctx = CoroutineName("name1") + Job()
    ctx.fold("") { acc, element ->
        "$acc + $element"
    }.also { println(it) } // CoroutineName(name1) + JobImpl{Active}@5910e440

    val empty = emptyList<CoroutineContext>()
    ctx.fold(empty) { acc, element ->
        acc + element
    }
        .joinToString()
        .also(::println) // CoroutineName(name1), JobImpl{Active}@5910e440
}
