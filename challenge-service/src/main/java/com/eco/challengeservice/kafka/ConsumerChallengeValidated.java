package com.eco.challengeservice.kafka;

import com.eco.challengeservice.dto.ChallengePlayerDto;
import java.util.concurrent.CountDownLatch;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerChallengeValidated {


    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.challengeValidated}", groupId = "${spring.kafka.group-id}")
    public void receive(ChallengePlayerDto payload) {
        latch.countDown();
    }

}
