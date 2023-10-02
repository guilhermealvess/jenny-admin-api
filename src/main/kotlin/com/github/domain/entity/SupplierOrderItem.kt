package com.github.domain.entity

import java.time.LocalDateTime
import java.util.UUID

enum class SupplierOrderItemStatus {
    PENDING,
    RECEIVED,
    RETURING,
    CANCELED,
}

class SupplierOrderItem(
    val id: UUID,
    val name: String,
    val code: String,
    val amount: UInt,
    private var status: SupplierOrderItemStatus,
    val quantity: UInt,
    val supplierOrderId: UUID,
    val createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime,
    private var receivedAt: LocalDateTime?,
) {
    init {
        this.valid()
    }

    fun valid() {

    }

    fun cancel() {
        this.status = SupplierOrderItemStatus.CANCELED
        this.updatedAt = LocalDateTime.now()
    }

    fun receive() {
        val now = LocalDateTime.now()
        this.status = SupplierOrderItemStatus.RECEIVED
        this.receivedAt = now
        this.updatedAt = now
    }
}

fun factoryNewSupplierOrderItem(name: String, code: String, amount: UInt, quantity: UInt, supplierOrderId: UUID): SupplierOrderItem {
    val now = LocalDateTime.now()
    return SupplierOrderItem(UUID.randomUUID(), name, code, amount, SupplierOrderItemStatus.PENDING, quantity, supplierOrderId, now, now, null)
}