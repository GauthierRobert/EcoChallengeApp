package com.eco.challengeuserservice.kafka;

import com.eco.challengeuserservice.dto.ChallengePlayerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerChallengeValidated {

    private static final Logger logger = LoggerFactory.getLogger(ProducerChallengeValidated.class);

    @Value("${spring.kafka.topic.challengeValidated}")
    private String CHALLENGE_VALIDATED_TOPIC;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(ChallengePlayerDto message) {
        logger.info(String.format("#### -> Producing message Challenge Validated -> %s", message.getId()));
        this.kafkaTemplate.send(CHALLENGE_VALIDATED_TOPIC, message);
    }
}