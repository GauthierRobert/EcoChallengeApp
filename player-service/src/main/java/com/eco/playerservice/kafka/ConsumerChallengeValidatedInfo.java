package com.eco.playerservice.kafka;

import com.eco.playerservice.dto.ChallengeValidatedDto;
import com.eco.playerservice.service.PlayerService;
import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerChallengeValidatedInfo {

    @Autowired
    private PlayerService playerService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.challengeValidatedInfo}",
                   groupId = "${spring.kafka.group-id}",
                   containerFactory = "challengeValidatedInfoKafkaListenerContainerFactory")
    public void receive(ChallengeValidatedDto payload) {
        playerService.validate(payload);
        latch.countDown();
    }

}
