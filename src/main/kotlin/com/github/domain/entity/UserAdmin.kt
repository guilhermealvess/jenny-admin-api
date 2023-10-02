package com.github.domain.entity

import java.time.LocalDateTime
import java.util.*

enum class Permissions {
    COMMOM,
    SUPER_USER,
}

enum class UserAdminStatus {
    ACTIVE,
    DESACTIVE,
}

class UserAdmin(name: String, email: String, username: String, password: String, status: String, phoneNumber: String) {
    val id = UUID.randomUUID()
    val name: String = name.uppercase()
    val email: String = email
    val username: String = username
    val password: String = this.encodePassword(password)
    val status = UserAdminStatus.ACTIVE
    val permission = Permissions.COMMOM
    val phoneNumber = phoneNumber
    val lastLogin = LocalDateTime.now()
    val createdAt = LocalDateTime.now()
    val updatedAt = LocalDateTime.now()

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
