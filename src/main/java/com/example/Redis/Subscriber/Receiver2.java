package com.example.Redis.Subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Receiver2 implements MessageListener {

    Logger logger = (Logger) LoggerFactory.getLogger(Receiver2.class);

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(bytes);
        logger.info("Message Consumed by receiver 2 ===> {}", message.toString());
    }
}
