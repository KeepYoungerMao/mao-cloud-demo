package com.mao.gateway.service;

import com.mao.common.response.ResponseData;

/**
 * create by mzx at 2021/1/29 23:07
 */
public interface FallbackService {

    ResponseData<?> fallback(String server);

}
