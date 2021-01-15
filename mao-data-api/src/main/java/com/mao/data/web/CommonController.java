package com.mao.data.web;

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

    @GetMapping("test")
    public String test() {
        return "test is ok";
    }

}
