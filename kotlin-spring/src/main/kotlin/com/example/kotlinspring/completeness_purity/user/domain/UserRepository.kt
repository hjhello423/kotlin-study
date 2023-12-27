package com.example.kotlinspring.completeness_purity.user.domain

interface UserRepository {

    fun save(user: User): User
    fun getById(userId: Long): User

    fun getByEmail(email: String): User?
    fun getAll(): List<User>
}
