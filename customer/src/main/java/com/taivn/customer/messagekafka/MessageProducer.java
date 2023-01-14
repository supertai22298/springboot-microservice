package com.taivn.customer.messagekafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Tai VN
 * @date 1/14/2023
 */

@Component
@Log4j2
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${customer.kafka.topic}")
    private String topic;

    public void sendMessage(String message) {
        log.info(String.format("SEND A MESSAGE %s TO TOPIC %s", message, topic));
        kafkaTemplate.send(topic, message);
    }
}
