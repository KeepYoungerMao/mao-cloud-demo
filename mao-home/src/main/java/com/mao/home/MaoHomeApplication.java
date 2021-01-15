package com.mao.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MaoHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoHomeApplication.class, args);
    }

}
