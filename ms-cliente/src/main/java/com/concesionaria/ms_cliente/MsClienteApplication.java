package com.concesionaria.ms_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //Esta dependecia se agrega en el servicio que quiere llamar a otro servicio. Ej MS1 llama a MS2
public class MsClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClienteApplication.class, args);
	}

}
