package com.eco.authservice.config.mongodb;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.eco.authservice.repository")
public class MongoConfig {

}
