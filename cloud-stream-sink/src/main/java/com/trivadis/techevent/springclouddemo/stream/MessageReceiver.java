package com.trivadis.techevent.springclouddemo.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class MessageReceiver {

	@StreamListener(Sink.INPUT)
	public void getMessage(String message) {
		System.out.println("Received message: " + message);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MessageReceiver.class, args);
	}
}
