package com.trivadis.techevent.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DiscoverableService {

	@RequestMapping("/greeting")
	public String greeting(@RequestHeader HttpHeaders headers) {
		return "Hello from Discoverable Service ! <br><br>"
				+ headers.toSingleValueMap();
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscoverableService.class, args);
	}

}