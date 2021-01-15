package com.mao.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 使用Spring Cloud Gateway不要添加Spring-boot-starter-web,spring-boot-starter-tomcat
 * 由于它底层是neety + WebFlux实现
 */
@EnableEurekaClient
@SpringBootApplication
public class MaoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoGatewayApplication.class, args);
    }

}
