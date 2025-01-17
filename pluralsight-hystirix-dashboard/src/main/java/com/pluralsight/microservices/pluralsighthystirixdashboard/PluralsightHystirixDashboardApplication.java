package com.pluralsight.microservices.pluralsighthystirixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableTurbine
public class PluralsightHystirixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightHystirixDashboardApplication.class, args);
	}

}
