package com.trivadis.techevent.springclouddemo.hystrix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@RestController
public class HystrixClient {

	@Autowired
	private FallbackableService fallbackableService;
	
	@RequestMapping("/get-greeting")
	public String greeting() {
		return fallbackableService.getFallbackableGreeting();
	}
	
	@RequestMapping("/get-greeting-30")
	public String greeting30() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i=0;i<30;i++) {
			executor.submit(() -> {
				fallbackableService.getFallbackableGreeting();
			});
			
			
			
		}
		return "sent 30 requests";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixClient.class, args);
	}

}