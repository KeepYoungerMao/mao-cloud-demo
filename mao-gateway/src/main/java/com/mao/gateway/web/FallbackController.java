package com.mao.gateway.web;

import com.mao.common.response.ResponseData;
import com.mao.gateway.service.FallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : create by zongx at 2021/1/15 15:15
 */
@RestController
@RequestMapping("gateway")
public class FallbackController {

    private FallbackService fallbackService;

    @Autowired
    public void setFallbackService(FallbackService fallbackService) {
        this.fallbackService = fallbackService;
    }

    @GetMapping("fallback/{server}")
    public ResponseData<?> fallback(@PathVariable("server") String server) {
        return fallbackService.fallback(server);
    }

}
