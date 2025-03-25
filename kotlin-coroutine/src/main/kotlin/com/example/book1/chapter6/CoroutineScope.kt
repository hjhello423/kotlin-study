package com.example.book1.chapter6

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//suspend fun getArticlesForUser(userToken: String?): List<ArticleJson> = coroutineScope {
//    val articles = async { articleRepository.getArticles() }
//    val user = userService.getuser(userToken)
//    articles.await()
//        .filter { canSeeOnList(user, it) }
//        .map { toArticleJson(it) }
//}

suspend fun main(): Unit = coroutineScope {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}
