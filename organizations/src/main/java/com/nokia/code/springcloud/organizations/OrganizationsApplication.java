package com.nokia.code.springcloud.organizations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class) //@EnableBinding 注解告诉Spring Cloud Stream希望将服务绑定到消息代理。
public class OrganizationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationsApplication.class, args);
	}

}
