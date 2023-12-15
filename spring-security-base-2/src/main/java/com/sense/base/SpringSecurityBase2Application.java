package com.sense.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sense.base.mapper")
public class SpringSecurityBase2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBase2Application.class, args);
    }

}
