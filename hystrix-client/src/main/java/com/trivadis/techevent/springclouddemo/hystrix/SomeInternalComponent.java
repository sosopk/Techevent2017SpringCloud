package com.trivadis.techevent.springclouddemo.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class SomeInternalComponent {

	@Autowired
	private MyDiscoverableService discoverableService;

	
	@HystrixCommand(fallbackMethod = "fallbackGreeting", 
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String getRealGreeting() {
		return "Output from DiscoverableService:<br>"
				+ "---------------------------------------------<br><br>" 
	            + discoverableService.greeting();
	}

	public String fallbackGreeting() {
		return "Hystrix fallback greeting";
	}
}
