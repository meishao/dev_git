package com.vbiz.privatecloud.messaging;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleListenerConfig {
    String queueName = "hello";
    
    @Bean
    public ConnectionFactory connectionFactory() {
    	//String rabbitmq_host = "localhost";
    	String rabbitmq_host = "192.168.2.121";
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitmq_host);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
    @Bean
    public SimpleMessageListenerContainer listenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(queueName);
        //container.setMessageListener(new MessageListenerAdapter(new HelloWorldHandler()));
        container.setMessageListener(new MessageListenerAdapter(new HelloWorldHandler(), new JsonMessageConverter()));
        return container;
    }
}