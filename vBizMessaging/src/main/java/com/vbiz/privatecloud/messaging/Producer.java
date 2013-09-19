package com.vbiz.privatecloud.messaging;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {
    public static void main(String[] args){
        new AnnotationConfigApplicationContext(ProducerConfig.class);
    }
}