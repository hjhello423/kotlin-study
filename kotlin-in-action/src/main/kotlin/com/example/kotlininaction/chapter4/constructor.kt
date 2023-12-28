package com.example.kotlininaction.chapter4

class User constructor(_nickname: String) { // 파라미터가 하나뿐인 주 생성자, constructor 키워드 생략 가능
    val nickname: String

    init { // 초기화 블록
        this.nickname = _nickname
    }
}
