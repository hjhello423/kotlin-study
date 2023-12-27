package chapter3.코틀린에서_컬렉션_만들기

fun main() {
    makeCollection()

}

fun makeCollection() {
    val set = hashSetOf(1, 7, 53) // HashSet<Int>의 인스턴스를 만든다.
    val list = arrayListOf(1, 7, 53) // ArrayList<Int>의 인스턴스를 만든다.
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") // HashMap<Int, String>의 인스턴스를 만든다.

    println("set= $set, class= ${set.javaClass}")
    println("list= $list, class= ${list.javaClass}")
    println("map= $map, class= ${map.javaClass}")
}
