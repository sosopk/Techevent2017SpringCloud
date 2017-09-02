package com.trivadis.techevent.springclouddemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClient {
     
    @Value("${user.role}")
    private String role;
 
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
 
    @RequestMapping("/checkrole")
    public String checkRole() {
        return String.format("Current role %s...", role);
    }
}