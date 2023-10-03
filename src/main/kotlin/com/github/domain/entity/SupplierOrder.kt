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

    class Builder {
        private lateinit var label: String
        private var freightValue: UInt = 0u
        private lateinit var responsible: String
        private var receivedAt: LocalDateTime? = null
        private lateinit var orderId: String
        private lateinit var paymentType: PaymentType
        private lateinit var safeDateExpire: LocalDateTime
        private lateinit var status: SupplierOrderStatus
        private lateinit var createdBy: String
        private lateinit var createdAt: LocalDateTime
        private lateinit var updatedAt: LocalDateTime

        fun setLabel(label: String): Builder {
            this.label = label
            return this
        }

        fun setFreightValue(freightValue: UInt): Builder {
            this.freightValue = freightValue
            return this
        }

        fun setResponsible(responsible: String): Builder {
            this.responsible = responsible
            return this
        }

        fun setOrderId(orderId: String): Builder {
            this.orderId = orderId
            return this
        }

        fun setPaymentType(paymentType: PaymentType): Builder {
            this.paymentType = paymentType
            return this
        }

        fun setSafeDateExpire(safeDateExpire: LocalDateTime): Builder {
            this.safeDateExpire
            return this
        }

        fun setCreatedBy(createdBy: String): Builder {
            this.createdBy = createdBy
            return this
        }

        fun build(): SupplierOrder {
            val now = LocalDateTime.now()
            return SupplierOrder(
                UUID.randomUUID(),
                label,
                freightValue,
                responsible,
                receivedAt,
                orderId,
                paymentType,
                safeDateExpire,
                status,
                createdBy,
                now,
                now
            )
        }
    }

    fun applyReceive() {
        val now = LocalDateTime.now()
        this.receivedAt = now
        this.updatedAt = now
        this.status = SupplierOrderStatus.RECEIVED
    }
}
