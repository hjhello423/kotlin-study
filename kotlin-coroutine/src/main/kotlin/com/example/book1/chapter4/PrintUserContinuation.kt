package com.example.book1.chapter4

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

class PrintUserContinuation(
    val completion: Continuation<Unit>, val token: String
) : Continuation<String> {
    override val context: CoroutineContext
        get() = completion.context
    var result: Result<Any>? = null
    var label = 0
    var userId: String? = null

    override fun resumeWith(result: Result<String>) {
        this.result = result
//        val res = try {
//            val r = printUser(token, this)
//            if (r == COROUTINE_SUSPENDED) {
//                return
//            }
//            Result.success(r as Unit)
//        } catch (e: Throwable) {
//            Result.failure(e)
//        }
//        completion.resumeWith(res)
    }
}
