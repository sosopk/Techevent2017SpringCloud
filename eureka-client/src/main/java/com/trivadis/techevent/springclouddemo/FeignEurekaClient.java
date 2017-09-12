package com.trivadis.techevent.springclouddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignEurekaClient {
	@Autowired
	private MyDiscoverableService myDiscoverableService;

	@RequestMapping("/get-greeting")
	public String greeting() {
		return myDiscoverableService.greeting();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignEurekaClient.class, args);
	}

	
	
	// ---- other ways to access registry

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/get-greeting2")
	public String greeting2(Model model) {

		// 1.
		// List<ServiceInstance> serverInstances = discoveryClient.getInstances("my-discoverable-service");
		// return serverInstances.toString();
		//
		// 2.
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("my-discoverable-service", false);
		return "" + instance.getPort();
		//
		// 3.
		// return ""+eurekaClient.getInstancesById("my-discoverable-service").size();
	}
}