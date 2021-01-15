package com.mao.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MaoDataApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoDataApiApplication.class, args);
    }

}
