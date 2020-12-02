package com.poc.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PocCircuitBreakerResilient4jApplication {
	public static void main(String[] args) {
		SpringApplication.run(PocCircuitBreakerResilient4jApplication.class, args);
	}
}
