package com.mao.base.service;

import com.mao.base.grpc.Id;
import com.mao.base.grpc.IdGeneratorGrpc;
import com.mao.base.grpc.IdParam;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * create by mzx at 2021/2/17 16:43
 */
@GRpcService
public class BaseApiService extends IdGeneratorGrpc.IdGeneratorImplBase {

    @Override
    public void nextId(IdParam request, StreamObserver<Id> responseObserver) {
        responseObserver.onNext(Id.newBuilder().setId("1234567").build());
        responseObserver.onCompleted();
    }

}
