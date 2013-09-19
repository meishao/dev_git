package com.vbiz.privatecloud.messaging;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledProducerTask {
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    private final AtomicInteger counter = new AtomicInteger();
    
    @Scheduled(fixedDelay=5000)
    public void sendMessage() {
        String message = "Message Json sent at " + new Date();
        //rabbitTemplate.convertAndSend(message);
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.setKey(counter.incrementAndGet());
        simplePojo.setMessage(message);
        rabbitTemplate.convertAndSend(simplePojo);
        System.out.println(message);
    }
}