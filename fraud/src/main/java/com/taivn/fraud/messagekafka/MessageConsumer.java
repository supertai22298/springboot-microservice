package com.taivn.fraud.messagekafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Tai VN
 * @date 1/14/2023
 */
@Component
@Log4j2
public class MessageConsumer {
    private final String topic = "CUSTOMER-MESSAGE-TOPIC";

    @Autowired
    private MessageDataSource dataSource;

    @KafkaListener(topics = topic, groupId = "xyz")
    public void receiveMessage(String message) {
        log.info("RECEIVE A MESSAGE {}", message);
        dataSource.setMessageList(message);
    }
}
