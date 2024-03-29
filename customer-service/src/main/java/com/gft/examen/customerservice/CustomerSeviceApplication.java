package com.gft.examen.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSeviceApplication.class, args);
	}

}
