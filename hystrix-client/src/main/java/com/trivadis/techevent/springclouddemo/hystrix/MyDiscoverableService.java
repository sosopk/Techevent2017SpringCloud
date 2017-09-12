package com.trivadis.techevent.springclouddemo.hystrix;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("my-discoverable-service")
public interface MyDiscoverableService {
    @RequestMapping("/greeting")
    String greeting();
}