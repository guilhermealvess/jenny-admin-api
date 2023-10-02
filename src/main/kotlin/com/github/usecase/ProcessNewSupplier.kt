package com.github.usecase

import com.github.domain.entity.Supplier

interface ProcessNewSupplier {
    fun process(params: NewSupplierParams): Supplier
}

data class NewSupplierParams(
    val name: String
)
