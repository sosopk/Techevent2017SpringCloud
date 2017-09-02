package com.trivadis.techevent.springclouddemo.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class MessageSender {

	@Autowired
	Source source;

	@RequestMapping("/send")
	public String sendMessage(@RequestParam("text") String text) {
		//for (int i=0;i<10000;i++) 
		source.output().send(MessageBuilder.withPayload(text).build());
		return "Sending message: " + text;
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageSender.class, args);
	}
}
