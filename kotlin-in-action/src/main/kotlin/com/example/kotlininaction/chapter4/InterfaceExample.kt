package chapter4

fun main() {
    Button2().click()
}

interface Clickable {
    fun click() // 추상메서드
    fun showOff() = println("I'm clickable!") // 구현메서드
}

class Button : Clickable {
    override fun click() = println("I was clicked")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

class Button2 : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff() // 상위 타입의 메서드를 호출하려면 super<타입>을 사용한다.
    }
}

open class RichButton : Clickable { // open 클래스 -> 다른 클래스가 상속할 수 있다.
    fun disable() {} // final 메서드 -> 하위 클래스가 오버라이드할 수 없다.

    open fun animate() {} // open 메서드 -> 하위 클래스가 오버라이드할 수 있다.

    override fun click() {} // final 메서드, open -> 상위 클래스에서 선언된 함수를 override 한다.
}

abstract class Animated { // 추상 클래스
    abstract fun animate() // 추상 메서드 -> 하위 클래스에서 반드시 오버라이드 해야한다.

    open fun stopAnimating() {} // open 메서드 -> 하위 클래스가 선택적으로 오버라이드 할 수 있다. -> 구현부 {}가 있기 때문에

    fun animateTwice() {} // final 메서드 -> 하위 클래스가 오버라이드할 수 없다.
}

class AnimatedButton : Animated() {
    override fun animate() {
        TODO("Not yet implemented")
    }
}
