package com.concesionaria.eureka_discover_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoverServerApplication.class, args);
	}

}
