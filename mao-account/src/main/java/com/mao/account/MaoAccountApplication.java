package com.mao.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MaoAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoAccountApplication.class, args);
    }

}
