package com.eco.playerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Sso
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PlayerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceApplication.class, args);
	}

}
