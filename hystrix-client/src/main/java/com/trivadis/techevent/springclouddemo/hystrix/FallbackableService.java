package com.trivadis.techevent.springclouddemo.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class FallbackableService {

	@Autowired
	private GreetingClient greetingClient;

	
	@HystrixCommand(fallbackMethod = "defaultGreeting", 
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String getFallbackableGreeting() {
		return "Output from DiscoverableService:<br>"
				+ "---------------------------------------------<br><br>" 
	            + greetingClient.greeting();
	}

	public String defaultGreeting() {
		return "Hello, this is default greeting from Hystrix";
	}
}
