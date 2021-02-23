package com.mao.data.web;

import com.mao.common.response.ResponseData;
import com.mao.data.service.grpc.IdGeneratorGrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author : create by zongx at 2021/1/14 14:59
 */
@RestController
@RequestMapping("/api/data")
public class CommonController {

    private IdGeneratorGrpcService idGeneratorGrpcService;

    @Autowired
    public void setIdGeneratorGrpcService(IdGeneratorGrpcService idGeneratorGrpcService) {
        this.idGeneratorGrpcService = idGeneratorGrpcService;
    }

    @GetMapping("test")
    public ResponseData<?> test() {
        return idGeneratorGrpcService.nextId();
    }

}
