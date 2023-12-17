package com.sense.provider.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author jarvischang
 * @date 2023-12-6
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sense.provider.auth.mapper")
public class ProviderAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderAuthApplication.class, args);
	}

}
