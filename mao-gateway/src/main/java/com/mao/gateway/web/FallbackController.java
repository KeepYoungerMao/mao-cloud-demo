package com.mao.gateway.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : create by zongx at 2021/1/15 15:15
 */
@RestController
@RequestMapping("error")
public class FallbackController {

    @GetMapping("fallback")
    public String fallback() {
        return "server error";
    }

}
