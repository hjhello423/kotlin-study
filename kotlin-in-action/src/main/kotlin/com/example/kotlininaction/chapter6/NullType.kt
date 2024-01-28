package com.example.kotlininaction.chapter6


fun main() {

}

fun strLen(s: String): Int {
    return if(s != null) {
        s.length
    } else {
        0
    }
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No Address") // 주소가 없으면 예외
    with(address) { // address는 null이 아니다.
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

