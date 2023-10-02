package com.github.infra.repository

import com.github.domain.entity.Supplier
import com.github.domain.repository.SupplierRepository
import com.github.infra.repository.jpa.JpaSupplierRepository
import com.github.infra.repository.model.SupplierModel

class SupplierRepository(private val jpaSupplierRepository: JpaSupplierRepository): SupplierRepository {
    override fun save(supplier: Supplier) {
        val model = SupplierModel(supplier.id, supplier.name)

        this.jpaSupplierRepository.save(model)
    }
}