package com.trivadis.techevent.springclouddemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DiscoverableService {

    @Value("${foo}")
    private String foo;
	
    @RequestMapping("/greeting")
	public String greeting() {
		return String.format(
				"Hello from Discoverable Service. <br><br>" +
				"Properties: foo=<b>%s</b>", 
				foo);
	}
    
	public static void main(String[] args) {
		SpringApplication.run(DiscoverableService.class, args);
	}

}