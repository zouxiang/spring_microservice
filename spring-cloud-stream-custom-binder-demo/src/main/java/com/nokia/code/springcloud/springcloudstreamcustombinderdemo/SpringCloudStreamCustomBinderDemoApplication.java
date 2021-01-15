package com.nokia.code.springcloud.springcloudstreamcustombinderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudStreamCustomBinderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamCustomBinderDemoApplication.class, args);
	}

//	@Bean
//	public Function<String, String> uppercase() {
//		return value -> {
//			System.out.println("Received: " + value);
//			return value.toUpperCase();
//		};
//	}

}
