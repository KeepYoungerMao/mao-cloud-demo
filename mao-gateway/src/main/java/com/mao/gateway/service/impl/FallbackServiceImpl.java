package com.mao.gateway.service.impl;

import com.mao.common.response.MaoResponse;
import com.mao.common.response.ResponseData;
import com.mao.gateway.service.FallbackService;
import org.springframework.stereotype.Service;

/**
 * 网关降级处理
 * create by mzx at 2021/1/29 23:07
 */
@Service
public class FallbackServiceImpl extends MaoResponse implements FallbackService {

    @Override
    public ResponseData<?> fallback(String server) {
        return badGateway("service " + server + "not started.");
    }

}
