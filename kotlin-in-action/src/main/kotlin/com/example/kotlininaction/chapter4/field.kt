package com.example.kotlininaction.chapter4

class User2(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent() // backing field에 접근할 때 field 식별자를 사용한다.
            )
            field = value  // backing field 값을 변경한다.
        }
}
