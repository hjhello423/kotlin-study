package com.example.kotlininaction.chapter4


fun main() {
    val person = listOf(Person("Bob"), Person("Alice"))
    println(person.sortedWith(Person.NameComparator))
}

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }
}