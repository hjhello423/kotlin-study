package com.example.kotlininaction.chapter5

fun main() {
    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())
}

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) { // 수신 객체를 지정한다. with 함수를 사용하면 stringBuilder를 this로 사용할 수 있다.
        for (letter in 'A'..'Z') {
            this.append(letter) // this를 명시해서 수신 객체의 메서드를 호출
        }
        append("\nNow I know the alphabet!") // this를 생략해도 된다.
        this.toString() // 람다의 결과값을 반환
    }
}

fun alphabet3() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun alphabet4() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()
