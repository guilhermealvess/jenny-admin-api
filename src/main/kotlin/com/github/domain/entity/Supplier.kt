package com.github.domain.entity

import java.time.LocalDateTime
import java.util.*

class Supplier(name: String) {
    val id = UUID.randomUUID()
    val name = name.uppercase()
    val createdAt = LocalDateTime.now()
    val slug = slugfy(name)

    fun slugfy(name: String) = name
}