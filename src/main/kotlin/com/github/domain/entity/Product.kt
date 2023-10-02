package com.github.domain.entity

import java.time.LocalDateTime
import java.util.UUID

enum class ProductStatus {
    ACTIVE,
    SUSPEND,
}

class Product(
    val id: UUID,
    val name: String,
    val code: String,
    val status: ProductStatus,
    private var categories: MutableList<String>,
    private var material: String,
    val price: UInt,
    val cost: UInt,
    private var imagesUrl: MutableList<String>,
    val createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime,
    private var priceUpdatedAt: LocalDateTime,
) {
    init {
        this.valid()
    }

    fun valid() {
        TODO()
    }

    fun calcProfit(): Int {
        return 0
    }

    fun addImageUrl(url: String) {
        this.imagesUrl.add(url)
    }
}

fun factoryNewProduct(name: String, code: String, categories: MutableList<String>, material: String, price: UInt, cost: UInt, imagesUrl: MutableList<String>): Product {
    val now = LocalDateTime.now()
    return Product(
        UUID.randomUUID(),
        name.uppercase(),
        code.uppercase(),
        ProductStatus.ACTIVE,
        categories,
        material,
        price,
        cost,
        imagesUrl,
        now,
        now,
        now,
    )
}