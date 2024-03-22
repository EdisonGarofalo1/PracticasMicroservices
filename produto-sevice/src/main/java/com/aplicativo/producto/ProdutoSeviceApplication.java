package com.aplicativo.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProdutoSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoSeviceApplication.class, args);
		System.out.print(" hola producto todo bien");
	}

}
