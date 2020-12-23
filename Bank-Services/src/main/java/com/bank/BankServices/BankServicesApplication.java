package com.bank.BankServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServicesApplication.class, args);
	}

}
