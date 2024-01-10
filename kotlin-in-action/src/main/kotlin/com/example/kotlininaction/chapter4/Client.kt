package com.example.kotlininaction.chapter4

fun main() {
    val client1 = Client("홍길동", 1123)
    val client2 = Client("홍길동", 1123)
    println("client1 == client2 -> ${client1 == client2}")

    val mutableClient = MutableClient("홍길동", 1111)
    println("mutableClient -> ${mutableClient}")
    mutableClient.update("홍길동2", 2222)
    println("mutableClient update -> ${mutableClient}")
}

class Client(val name: String, val postalCode: Int) {

    override fun toString(): String {
        return "Client(name='$name', postalCode=$postalCode)"
    }

    override fun equals(other: Any?): Boolean { // Any는 java.lang.Object에 대응하는 클래스이다.
        if (this === other) return true // 참조를 비교한다.
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

data class MutableClient(var name: String, var postalCode: Int) {

    fun update(name: String, postalCode: Int) {
        this.name = name
        this.postalCode = postalCode
    }
}
