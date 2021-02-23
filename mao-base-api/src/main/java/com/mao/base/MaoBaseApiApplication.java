package com.mao.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MaoBaseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoBaseApiApplication.class, args);
    }

}
