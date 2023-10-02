package com.github.domain.entity

import java.time.LocalDateTime
import java.util.*

class Supplier(val name: String, val description: String, val site: String) {
    val id = UUID.randomUUID()
    val slug = name
    val rate = 5.0
    val orders: List<String> = listOf()
}