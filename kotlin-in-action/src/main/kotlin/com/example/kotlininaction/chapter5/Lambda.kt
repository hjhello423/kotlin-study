package com.example.kotlininaction.chapter5


fun main() {
    val peoples = listOf(Person("길동", 20), Person("철수", 30), Person("영희", 40))

    findTheOldest(peoples)

    val oldestPeople = peoples.maxBy { it.age } // 람다를 사용한 방법
    println("oldestPeople -> ${oldestPeople}")

    peoples.maxBy() { p: Person -> p.age }
    peoples.maxBy { p: Person -> p.age }
    peoples.maxBy { p -> p.age }
    peoples.maxBy { it.age }

    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }

    run (::salute) // 최상위 함수 참조

    peoples.maxBy (Person::age)
    peoples.maxBy {p -> p.age}
    peoples.maxBy { it.age }

    val createPerson = ::Person
    val p = createPerson("길동", 20)
    println(p)

    val predicate = Person::isAdult
}

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0 // 가장 많은 나이 저장
    var theOldest: Person? = null // 가장 많은 나이의 사람 저장
    for (person in people) {
        if (person.age > maxAge) { // 최대값을 바꾼다
            maxAge = person.age
            theOldest = person
        }
    }
    println("theOldest -> ${theOldest}")
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0 // 람다에서 사용 할 변수
    var serverErrors = 0

    responses.forEach { // 람다 호출
        if (it.startsWith("4")) {
            clientErrors++ // 람다에서 외부변수를 변경한다.
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun salute() = println("Salute!")

fun Person.isAdult() = age >= 21