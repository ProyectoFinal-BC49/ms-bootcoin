package com.nttdatabc.msbootcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsBootcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBootcoinApplication.class, args);
	}

}
