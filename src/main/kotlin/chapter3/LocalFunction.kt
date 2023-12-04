package chapter3

fun main() {
    val user = User(1, "", "")
    saveUser(user)
}

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) { // 로컬 함수
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName") // User의 프로퍼티 직접 사용
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave() // 확장 함수 호출
    // user 저장 로직
}
