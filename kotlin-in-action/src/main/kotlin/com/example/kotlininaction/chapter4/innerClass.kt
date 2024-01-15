package com.example.kotlininaction.chapter4

import java.io.Serializable


fun main() {
    val button = Button()
    val currentState = button.getCurrentState()

    println("currentState: $currentState")
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState : State {} // 자바의 static 중첩 클래스와 같다.
    inner class ButtonState2 : State {} // 자바의 inner 클래스와 같다.
}
