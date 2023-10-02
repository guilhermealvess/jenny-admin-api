package com.github.domain.entity

import java.time.LocalDateTime
import java.util.UUID

enum class PaymentType {
    MONEY,
    PIX,
    DEBIT,
    CREDIT,
    INSTALLMENTS,
}

enum class SupplierOrderStatus {
    PENDING,
    CANCELED,
    RECEIVED,
    RETURNING,
}

class SupplierOrder(
    val id: UUID,
    val label: String,
    val freightValue: UInt,
    val responsible: String,
    private var receivedAt: LocalDateTime?,
    val orderId: String,
    val paymentType: PaymentType,
    val safeDateExpire: LocalDateTime,
    private var status: SupplierOrderStatus,
    val createdBy: String,
    val createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime,
) {
    init {
        this.valid()
    }

    fun valid() {
        if(this.status == SupplierOrderStatus.RECEIVED && this.receivedAt == null) {
            throw Error("receivedAt is required")
        }
    }

    fun applyReceive() {
        val now = LocalDateTime.now()
        this.receivedAt = now
        this.updatedAt = now
        this.status = SupplierOrderStatus.RECEIVED
    }
}

fun factoryNewSupplierOrder(
    label: String,
    freightValue: UInt,
    responsible: String,
    orderId: String,
    paymentType: PaymentType,
    safeDateExpire: LocalDateTime,
    createdBy: String,
): SupplierOrder {
    val now = LocalDateTime.now()
    return SupplierOrder(
        UUID.randomUUID(),
        label.uppercase(),
        freightValue,
        responsible,
        null,
        orderId,
        paymentType,
        safeDateExpire,
        SupplierOrderStatus.PENDING,
        createdBy,
        now,
        now,
    )
}

