package com.github.usecase

interface NewSupplierOrder {
    fun process()
}

data class NewSupplierOrderParams(
    val name: String,
)

class NewSupplierOrderImpl: NewSupplierOrder {
    override fun process() {
        TODO("Not yet implemented")
    }
}