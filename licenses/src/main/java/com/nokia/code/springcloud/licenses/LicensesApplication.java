package com.nokia.code.springcloud.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class LicensesApplication {
    public static void main(String[] args) {
        SpringApplication.run(LicensesApplication.class, args);
    }

}
