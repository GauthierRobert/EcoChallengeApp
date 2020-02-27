package com.eco.contestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ContestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContestServiceApplication.class, args);
	}

}
