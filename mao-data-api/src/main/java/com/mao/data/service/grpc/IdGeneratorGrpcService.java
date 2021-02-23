package com.mao.data.service.grpc;

import com.mao.base.grpc.Id;
import com.mao.base.grpc.IdGeneratorGrpc;
import com.mao.base.grpc.IdParam;
import com.mao.common.response.MaoResponse;
import com.mao.common.response.ResponseData;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * create by mzx at 2021/2/18 9:14
 */
@Service
public class IdGeneratorGrpcService extends MaoResponse {

    private IdGeneratorGrpc.IdGeneratorBlockingStub idGeneratorBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost",20001).usePlaintext().build();
        idGeneratorBlockingStub = IdGeneratorGrpc.newBlockingStub(managedChannel);
    }

    public ResponseData<?> nextId() {
        Id id = idGeneratorBlockingStub.nextId(IdParam.newBuilder().setDataCenter(1).build());
        return ok(id.getId());
    }

}
