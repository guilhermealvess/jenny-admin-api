package com.github.infra.repository.jpa

import com.github.infra.repository.model.SupplierModel
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.UUID

@Repository
interface JpaSupplierRepository: JpaRepository<SupplierModel, UUID> {
}