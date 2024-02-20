package com.example.chapter11

import com.example.chapter3.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

data class Details(val name: String, val followers: Int)
data class Tweet(val tweet: String)

fun getFollowersNumber(): Int {
    throw Error("service error")
}

suspend fun getUserName(): String {
    delay(500)
    return "Kotlin"
}

suspend fun getTweets(): List<Tweet> {
    return listOf(Tweet("hello"), Tweet("world"))
}

suspend fun CoroutineScope.getUserDetails1(): Details {
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    return Details(userName.await(), followersNumber.await())
}

suspend fun getUserDetails2(): Details = coroutineScope {
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    Details(userName.await(), followersNumber.await())
}

fun main() = runBlocking {
    val details = try {
//        getUserDetails1()
        getUserDetails2()
    } catch (e: Error) {
        null
    }
    val tweets = async { getTweets() }
    println("user: $details")
    println("tweets: ${tweets.await()}")
}
