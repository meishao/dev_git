package com.vbiz.privatecloud.messaging;


public class HelloWorldHandler {
    public void handleMessage(SimplePojo simplePojo) {
        System.out.println("Received: Key = " + simplePojo.getKey() 
        		+ ", message = " + simplePojo.getMessage());
    }
}


/*
public class HelloWorldHandler {
	public void handleMessage(String message) {
		//JsonMessageConverter jmc = new JsonMessageConverter();
		//String u = (String) jmc.fromMessage(message);
		//System.out.println("received: " + u);
		System.out.println("received: " + message);
	}
}
*/