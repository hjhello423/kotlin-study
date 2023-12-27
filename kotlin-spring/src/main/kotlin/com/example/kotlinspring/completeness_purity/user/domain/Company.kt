package com.example.kotlinspring.completeness_purity.user.domain

import jakarta.persistence.Embeddable

@Embeddable
class Company(
    var domain: String,
) {
    fun isEmailCorporate(email: String): Boolean {
        val emailDomain = email.split('@')[1]
        return emailDomain === domain
    }
}
