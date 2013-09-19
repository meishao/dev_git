package com.vbiz.privatecloud.messaging;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ProducerConfig {
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
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setRoutingKey(this.queueName);
        rabbitTemplate.setMessageConverter(new JsonMessageConverter());
        return rabbitTemplate;
    }
    
    @Bean
    public ScheduledProducerTask scheduledProducerTask(){
        return new ScheduledProducerTask();
    }
}