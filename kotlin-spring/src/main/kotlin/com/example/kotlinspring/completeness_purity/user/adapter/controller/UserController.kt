package com.example.kotlinspring.completeness_purity.user.adapter.controller

import com.example.kotlinspring.completeness_purity.user.domain.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userRepository: UserRepository,
) {

    @PostMapping("/change-email-completeness")
    fun completeness(userId: Long, newEmail: String): ResponseEntity<Void> {
        val user = userRepository.getById(userId)
        user.changeEmail(newEmail)
        userRepository.save(user)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/change-email-purity")
    fun purity(userId: Long, newEmail: String): ResponseEntity<Void> {
        userRepository.getByEmail(newEmail)
            ?: throw IllegalArgumentException("already use email") // 사용 중인 이메일 validation

        val user = userRepository.getById(userId)
        user.changeEmail(newEmail)
        userRepository.save(user)

        return ResponseEntity.ok().build()
    }

    @PostMapping("/change-email-purity2")
    fun purity2(userId: Long, newEmail: String): ResponseEntity<Void> {
        val user = userRepository.getById(userId)
        user.changeEmail(newEmail)
        userRepository.save(user)

        return ResponseEntity.ok().build()
    }

    @PostMapping("/change-email-performance")
    fun performance(userId: Long, newEmail: String): ResponseEntity<Void> {
        val allUsers = userRepository.getAll()

        val user = (allUsers.find { it.id == userId }
            ?: throw IllegalArgumentException("user not found"))

        user.changeEmail3(newEmail, allUsers);
        userRepository.save(user)

        return ResponseEntity.ok().build()
    }
}
