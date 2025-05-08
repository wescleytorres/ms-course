package com.wescleydev.hr_euroka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrEurokaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurokaServerApplication.class, args);
	}

}
