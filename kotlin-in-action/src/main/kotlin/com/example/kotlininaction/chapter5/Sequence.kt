package com.example.kotlininaction.chapter5

fun main() {
    val peoples = listOf(Person("길동", 20), Person("철수", 30), Person("영희", 40))

    val find = peoples.asSequence() // sequence 사용
        .map(Person::name)
        .filter { it.startsWith("철") }
        .toList()

    println(find)

    val naturalNumbers = generateSequence(0) { it + 1 } // 시퀀스 생성
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 } // 100이하의 수를 얻는다.
    println(numbersTo100.sum()) // 모든 지연 연산은 sum의 결과를 계산할 때 수행된다.
}
