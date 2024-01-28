package com.example.kotlininaction.chapter6

class Address(
    val streetAddress: String, val zipCode: Int,
    val city: String, val country: String
)

class Company(val name: String, val address: Address?)

class Person(val firstName: String, val lastName: String, val company: Company?) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false // 타입이 서로 일치하지 않으면 false를 반환

        return otherPerson.firstName == firstName && // 안전한 캐스트를 하고 나면 otherPerson이 Person 타입으로 스마트 캐스트 된다.
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}
