package com.github.infra.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name = "suppliers")
data class SupplierModel(
    @Id
    val Id: UUID,

    @Column
    val name: String
)