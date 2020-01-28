package com.eco.playerservice;

import com.eco.userservice.dto.UserDto;
import com.eco.userservice.service.AccountService;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerUserCreated {

    @Autowired
    private AccountService accountService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(UserDto payload) {
        accountService.doSomething(payload);
        latch.countDown();
    }

}
