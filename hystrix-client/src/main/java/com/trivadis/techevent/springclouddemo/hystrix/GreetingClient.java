package com.trivadis.techevent.springclouddemo.hystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-discoverable-service")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}