package com.eco.challengeuserservice;

import com.eco.challengeuserservice.dto.PlayerDto;
import com.eco.challengeuserservice.service.ChallengePlayerService;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerPlayerCreated {

    @Autowired
    private ChallengePlayerService challengePlayerService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.playerCreated}", groupId = "${spring.kafka.group-id}")
    public void receive(PlayerDto payload) {
        challengePlayerService.save(payload);
        latch.countDown();
    }

}
