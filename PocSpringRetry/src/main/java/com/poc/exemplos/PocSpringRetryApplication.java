package com.poc.exemplos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableFeignClients
@EnableRetry
@SpringBootApplication
public class PocSpringRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringRetryApplication.class, args);
	}

}
