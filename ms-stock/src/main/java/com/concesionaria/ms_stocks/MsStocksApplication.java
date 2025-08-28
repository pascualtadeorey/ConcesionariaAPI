package com.concesionaria.ms_stocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // cliente eureka
@EnableFeignClients // Escanea los clientes Feign
public class MsStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStocksApplication.class, args);
	}

}
