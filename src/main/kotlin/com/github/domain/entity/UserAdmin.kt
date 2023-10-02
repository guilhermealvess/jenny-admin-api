package com.github.domain.entity

import java.time.LocalDateTime
import java.util.*

class UserAdmin(name: String, email: String, username: String, password: String, lastLogin: LocalDateTime, status: String, imageUrl: String) {
    val id = UUID.randomUUID()
    val name: String = name.uppercase()
    val email: String = email
    val username: String = username
    val password: String = this.encodePassword(password)
    val status = UserAdminStatus.ACTIVE
    val lastLogin = lastLogin
    val imageUrl = imageUrl
    val isSuperUser = false

    init {
        validate()
    }

    private fun encodePassword(pass: String): String {
        return pass
    }

    fun validate() {
        TODO("validate")
    }
}


enum class UserAdminStatus {
    ACTIVE,
    DESACTIVE,
}