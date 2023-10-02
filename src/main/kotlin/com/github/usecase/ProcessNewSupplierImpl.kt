package com.github.usecase

import com.github.domain.entity.Supplier
import com.github.domain.repository.SupplierRepository

class ProcessNewSupplierImpl(val reposirory: SupplierRepository): ProcessNewSupplier {
    override fun process(params: NewSupplierParams): Supplier {
        val supplier = Supplier(params.name)

        this.reposirory.save(supplier)

        return supplier
    }
}