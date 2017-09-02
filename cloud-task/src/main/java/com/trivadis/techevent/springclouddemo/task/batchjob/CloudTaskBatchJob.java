package com.trivadis.techevent.springclouddemo.task.batchjob;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@EnableBatchProcessing
@SpringBootApplication
public class CloudTaskBatchJob {

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskBatchJob.class, args);
	}
}
