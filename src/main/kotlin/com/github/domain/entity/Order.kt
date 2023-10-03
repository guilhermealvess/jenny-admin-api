package com.github.domain.entity

import java.time.LocalDateTime
import java.util.UUID

enum class OrderStatus {
    DRAFT,
    PENDING,
    CANCELED,
    FINISHED,
}

enum class OrderPaymentType {
    MONEY,
    PIX,
    DEBIT,
    CREDIT,
    INSTALLMENTS,
}

class Order(
    val id: UUID,
    val label: String,
    val paymentType: OrderPaymentType,
    private var status: OrderStatus,
    val ownerContact: Contact?,
    private var imagesUrl: MutableList<String>?,
    val createdAt: LocalDateTime,
    val createdBy: String,
    private var updatedAt: LocalDateTime,
) {
    init {
        this.valid()
    }

    fun valid() {
        TODO()
    }

    fun setAsDraft() {
        this.status = OrderStatus.DRAFT
    }
}

class Contact(val phoneNumber: String, name: String, alias: String)

fun factoryNewOrder(label: String, paymentType: OrderPaymentType, ownerContact: Contact?, imagesUrl: MutableList<String>?, createdBy: String): Order {
    val now = LocalDateTime.now()
    return Order(
        UUID.randomUUID(),
        label,
        paymentType,
        OrderStatus.PENDING,
        ownerContact,
        imagesUrl,
        now,
        createdBy,
        now,
    )
}