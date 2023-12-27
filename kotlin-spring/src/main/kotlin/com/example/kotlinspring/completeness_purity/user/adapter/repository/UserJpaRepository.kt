package com.example.kotlinspring.completeness_purity.user.adapter.repository

import com.example.kotlinspring.completeness_purity.user.domain.User
import com.example.kotlinspring.completeness_purity.user.domain.UserRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : CrudRepository<User, Long>, UserRepository {

}
