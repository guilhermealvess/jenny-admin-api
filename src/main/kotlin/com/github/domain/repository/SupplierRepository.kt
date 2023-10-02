package com.github.domain.repository

import com.github.domain.entity.Supplier

interface SupplierRepository {
    fun save(supplier: Supplier)
}