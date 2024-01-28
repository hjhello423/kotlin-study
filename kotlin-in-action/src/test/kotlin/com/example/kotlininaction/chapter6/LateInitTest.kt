package com.example.kotlininaction.chapter6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LateInitTest {

    private lateinit var myService: MyService // 초기화하지 않고 null이 될 수 없는 property 선언

    @BeforeEach
    fun setUp() {
        myService = MyService() // 여기서 property 초기화
    }

    @Test
    fun testAction() {
        assertEquals("foo", myService.performAction()) // null 검사를 하지 않아도 된다.
    }
}

class MyService {
    fun performAction(): String = "foo"
}
