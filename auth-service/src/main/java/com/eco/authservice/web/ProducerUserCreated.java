package com.eco.authservice.web;

import com.eco.authservice.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerUserCreated {

    private static final Logger logger = LoggerFactory.getLogger(ProducerUserCreated.class);

    @Value("${spring.kafka.topic.userCreated}")
    private String USER_CREATED_TOPIC;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(UserDto message) {
        logger.info(String.format("#### -> Producing message -> %s", message.getUsername()));
        this.kafkaTemplate.send(USER_CREATED_TOPIC, message);
    }
}