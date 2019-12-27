package com.eco.userservice.web;

import com.eco.userservice.dto.UserDto;
import com.eco.userservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    @Autowired
    private AccountService emailService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(UserDto payload) {
        emailService.doSomething(payload);
        latch.countDown();
    }

}
