package com.trivadis.techevent.springclouddemo;

import java.util.Arrays;

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
public class DiscoverableService1 {

	@RequestMapping("/greeting")
	public String greeting(@RequestHeader HttpHeaders headers) {
		return "Hello from FIRST instance of Discoverable Service ! <br><br>"
				+ headers.toSingleValueMap();
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscoverableService1.class, args);
	}

}