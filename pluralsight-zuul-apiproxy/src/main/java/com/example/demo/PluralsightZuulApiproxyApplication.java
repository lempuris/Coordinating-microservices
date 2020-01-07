package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class PluralsightZuulApiproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightZuulApiproxyApplication.class, args);
	}

	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}

	@Bean
	public StartPreFilter preFilter() {
		return new StartPreFilter();
	}

	@Bean
	public StopPostFilter postFilter() {
		return new StopPostFilter();
	}

}
