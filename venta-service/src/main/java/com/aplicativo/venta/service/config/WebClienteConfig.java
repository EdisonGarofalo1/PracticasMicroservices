package com.aplicativo.venta.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClienteConfig {
	
	/* 
	@Bean
	    public WebClient.Builder webClient() {
	        return WebClient.builder();
	    }
	    
	    */
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
