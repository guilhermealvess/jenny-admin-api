package com.github.domain.entity

import java.time.LocalDateTime
import java.util.*

class Supplier(
    val id: UUID,
    val name: String,
    val description: String?,
    val slug: String,
    val site: String?,
    val supplierOrders: MutableList<SupplierOrder>?,
    val rate: Double?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    init {
        this.valid()
    }

    fun valid() {
        TODO()
    }
    class Builder {
        private lateinit var name: String
        private var site: String? = null
        private var description: String? = null
        private var supplierOrders: MutableList<SupplierOrder>? = null
        private fun slugFy(name: String): String = name.uppercase()

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setSite(site: String?): Builder {
            this.site = site
            return this
        }

        fun setDescription(description: String?): Builder {
            this.description = description
            return this
        }

        fun setSupplierOrders(supplierOrders: MutableList<SupplierOrder>?): Builder {
            this.supplierOrders = supplierOrders
            return this
        }

        fun build(): Supplier {
            val now = LocalDateTime.now()
            return Supplier(UUID.randomUUID(), name, description, slugFy(name), site, supplierOrders, null, now, now)
        }
    }
}
