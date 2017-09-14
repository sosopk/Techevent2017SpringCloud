# Techevent2017SpringCloud
Source code for Techevent 2017 session: Cloud Apps / Microservices made easy with Spring

## Config Server

<b>Projects to start:</b> config-server, config-client     

<b>URLs to Test:</b>
* curl -u myuser:mypass localhost:8888/config-client-dev.yml
* curl http://localhost:8081/checkrole 
* curl -X POST localhost:8081/refresh

## Service Discovery

<b>Projects to start:</b> eureka-server, eureka-client, my-discoverable-service x 2 (with different ports e.g. --server.port=18082 and --server.port=28082)

<b>URLs to Test:</b>
* http://localhost:8761/ - Eureka dashboard
* http://localhost:8761/eureka/apps - Rest Api
* http://localhost:8082/get-greeting - Eureka feign client

## Circuit Breaker - Hystrix

<b>Projects to start:</b> eureka-server, my-discoverable-service, calling-client, hystrix-dashboard

<b>URLs to Test:</b>
* http://localhost:8083/get-greeting - Calls fallbackable service
* http://localhost:8083/hystrix.stream - Hystrix event stream
* http://localhost:8084/hystrix  - Dashboard
* http://localhost:8083/get-greeting-30 - Simulate load

## Zuul - Api Gateway

<b>Projects to start:</b> my-discoverable-service, eureka-server, zuul-proxy

<b>URLs to Test:</b>
* http://localhost:8085/routes - List current routes
* http://localhost:8085/my-discoverable-service/greeting - Routing by id
* http://localhost:8085/google/search?q=lorem+ipsum - Routing by URL
* http://localhost:8085/hystrix.stream

## Spring Cloud Stream

<b>Projects to start:</b> cloud-stream-source and cloud-stream-sink

<b>URLs to Test:</b>
* http://localhost:8086/send?text=12345

## Spring Cloud Task

<b>Projects to start:</b> cloud-task

* Class CloudTaskBatchJob for Batch Task
* Class CloudTaskApp for CommandLineRunner Task