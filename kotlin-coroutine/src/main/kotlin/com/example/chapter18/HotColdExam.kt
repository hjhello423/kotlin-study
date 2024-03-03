package com.example.chapter18

fun main() {
    val l: List<String> = buildList {
        repeat(3) {
            add("User$it")
            println("L: Added User")
        }
    }

    val l2: List<String> = l.map {
        println("L: Processing")
        "Processed $it"
    }

    val s: Sequence<String> = sequence { // 중간 연산
        repeat(3) {
            yield("User$it")
            println("S: Added User")
        }
    }

    val s2: Sequence<String> = s.map {
        println("S: Processing")
        "Processed $it"
    }
}
