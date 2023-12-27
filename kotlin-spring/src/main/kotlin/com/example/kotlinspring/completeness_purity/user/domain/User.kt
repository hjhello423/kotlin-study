package com.example.kotlinspring.completeness_purity.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User(
    @Id
    var id: Long? = null,
    var email: String,
    var company: Company,
) {

    fun changeEmail(newEmail: String) {
        if (!company.isEmailCorporate(newEmail)) {
            throw IllegalArgumentException("Incorrect email domain")
        }
        email = newEmail
    }

    fun changeEmail2(newEmail: String, repository: UserRepository) {
        if (!company.isEmailCorporate(newEmail)) {
            throw IllegalArgumentException("Incorrect email domain")
        }

        repository.getByEmail(newEmail) ?: throw IllegalArgumentException("already use email") // 사용 중인 이메일 validation

        email = newEmail
    }

    fun changeEmail3(newEmail: String, allUsers: List<User>) {
        if (!company.isEmailCorporate(newEmail)) {
            throw IllegalArgumentException("Incorrect email domain")
        }

        val validate = allUsers.any() { it.email == newEmail && it != this } // 같은 이메일을 사용중인 유저가 있는지 찾는다.
        if (validate) {
            throw IllegalArgumentException("already use email")
        }

        email = newEmail
    }

}
