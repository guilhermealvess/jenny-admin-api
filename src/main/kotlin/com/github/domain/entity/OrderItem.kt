package com.github.domain.entity

import java.time.LocalDateTime
import java.util.UUID

class OrderItem(
    val id: UUID,
    val productId: UUID,
    val amount: UInt,
    val quantity: UInt,
    val createdAt: LocalDateTime,
) {
    init {
        this.valid()
    }

    fun valid() {
        TODO()
    }
}

fun factoryNewOrderItem(id: UUID, productId: UUID, amount: UInt, quantity: UInt): OrderItem {
    return OrderItem(
        id,
        productId,
        amount,
        quantity,
        LocalDateTime.now()
    )
}