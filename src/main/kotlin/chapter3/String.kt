package chapter3

fun main(args: Array<String>) {
    regex()
}

fun regex() {
    println("12.345-6.A".split("\\.|-".toRegex())) // 정규식을 사용하려면 toRegex()를 사용한다.
    println("12.345-6.A".split(".", "-")) // 정규식을 사용하지 않으면 문자열을 구분자로 사용한다.
}
