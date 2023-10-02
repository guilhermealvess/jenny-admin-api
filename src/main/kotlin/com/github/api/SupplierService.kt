package com.github.api

import com.github.SupplierReply
import com.github.SupplierRequest
import com.github.SupplierServiceGrpc
import com.github.infra.repository.SupplierRepository
import com.github.infra.repository.jpa.JpaSupplierRepository
import com.github.usecase.NewSupplierParams
import com.github.usecase.ProcessNewSupplierImpl
import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton

@Singleton
class SupplierService(private val jpaRepository: JpaSupplierRepository): SupplierServiceGrpc.SupplierServiceImplBase() {
    private val supplierRepository = SupplierRepository(jpaRepository)

    override fun create(request: SupplierRequest, responseObserver: StreamObserver<SupplierReply>) {
        val params = NewSupplierParams(request.name)
        var usecase = ProcessNewSupplierImpl(supplierRepository)

        val output = usecase.process(params)
        val reply = SupplierReply.newBuilder()
            .setId(output.id.toString())
            .setName(output.name)
            .build()

        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}