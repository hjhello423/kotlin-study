package com.example.chapter4

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

class MyFunctionContinuation(val completion: Continuation<Unit>) : Continuation<Unit> {
    override val context: CoroutineContext
        get() = completion.context
    var result: Result<Unit>? = null
    var label = 0
    var counter = 0

    override fun resumeWith(result: Result<Unit>) {
        this.result = result
//        val res = try {
//            val r = myFunction(this)
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
