package com.trivadis.techevent.springclouddemo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulProxy {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProxy.class, args);
	}

}