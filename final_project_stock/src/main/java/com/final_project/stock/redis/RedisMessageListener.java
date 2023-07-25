package com.final_project.stock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public RedisMessageListener(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String topic = new String(message.getChannel());
        String value = new String(message.getBody());
        messagingTemplate.convertAndSend("/stock/" + topic, value);
        
        
    }
}



