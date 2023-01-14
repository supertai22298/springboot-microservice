package com.taivn.fraud.messagekafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tai VN
 * @date 1/14/2023
 */
@Component
@Log4j2
public class MessageDataSource {
    private List<String> messageList = new ArrayList<>();

    public String getMessageList() {
        return messageList.toString();
    }

    public void setMessageList(String message) {
        this.messageList.add(message);
    }
}
