package com.microservices.tollrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TollrateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollrateServiceApplication.class, args);
	}

}
