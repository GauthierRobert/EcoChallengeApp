package com.eco.challengeservice.kafka;

import com.eco.challengeservice.dto.ChallengeValidatedDto;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerChallengeValidatedInfo {

    private static final Logger logger = LoggerFactory.getLogger(ProducerChallengeValidatedInfo.class);

    @Value("${spring.kafka.topic.challengeValidatedInfo}")
    private String PLAYER_CREATED_TOPIC;

    @Inject
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(ChallengeValidatedDto challengeValidated) {
        logger.info(String.format("#### -> Producing message -> %s", challengeValidated));
        this.kafkaTemplate.send(PLAYER_CREATED_TOPIC,  challengeValidated);
    }
}