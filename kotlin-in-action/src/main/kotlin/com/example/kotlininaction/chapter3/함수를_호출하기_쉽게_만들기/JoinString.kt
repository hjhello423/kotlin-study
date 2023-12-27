package chapter3.함수를_호출하기_쉽게_만들기

fun main() {
    val list = listOf(1, 2, 3)

    val joinToString1 =
        joinToString(collections = list, separator = "; ", prefix = "(", postfix = ")") // 인자중 일부의 이름을 명시적으로 지정할 수 있다.
    println(joinToString1)

    val joinToString2 = joinToString(collections = list) // 인자중 일부의 이름을 명시적으로 지정할 수 있다.
    println(joinToString2)

    performOperation()
    println(opCount)
}

fun <T> joinToString(
    collections: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collections.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0 // 최상위 프로퍼티

fun performOperation() {
    opCount++
}
