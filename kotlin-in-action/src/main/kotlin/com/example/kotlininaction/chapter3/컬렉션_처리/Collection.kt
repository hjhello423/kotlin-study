package chapter3.컬렉션_처리

fun main(args: Array<String>) {
    last()
    spreadOperator(listOf("one", "two", "three").toTypedArray())
    infix()
    destructuringDeclarations()
}

fun last() {
    val strings: List<String> = listOf("first", "second", "fourteenth")
    val last = strings.last()
    println("last = $last")

    val numbers: Collection<Int> = setOf(1, 14, 2)
    val max = numbers.maxOrNull()
    println("maxOrNull = $max")
}

fun spreadOperator(args: Array<String>) {
    val spread = listOf("args: ", *args) // spread 연산자가 배열의 내용을 펼쳐준다.
    println("spread = $spread")
}

fun infix() {
    1.to("one") // to는 일반 함수이다.
    1 to "one" // to는 중위 호출이다.

    val (number, name) = 1 to "one"
    println("to: number = $number, name = $name")

    val (number2, name2) = 1 myInfix "one"
    println("myInfix: number = $number2, name = $name2")
}

fun destructuringDeclarations() {
    val (number, name) = 1 to "one"

    for ((index, element) in listOf("a", "b", "c").withIndex()) {
        println("index = $index, element = $element")
    }
}

infix fun Any.myInfix(other: Any) = Pair(this, other) // infix 변경자를 함수 선업 앞에 추가하여 함수를 중위 호출에 사용한다.
