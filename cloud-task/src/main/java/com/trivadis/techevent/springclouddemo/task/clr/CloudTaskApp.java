package com.trivadis.techevent.springclouddemo.task.clr;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class CloudTaskApp {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return strings -> 
			System.out.println("Executed at :" + new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskApp.class, args);
	}
}
