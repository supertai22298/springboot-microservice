package com.taivn.customer.messagekafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Tai VN
 * @date 1/14/2023
 */
@Component
@Log4j2
public class MessageInternalConsumer {

    @KafkaListener(topics = "CUSTOMER-MESSAGE-TOPIC", groupId = "abc")
    public void receiveMessage(String message) {
        log.info("RECEIVE A MESSAGE {}", message);
    }
}
