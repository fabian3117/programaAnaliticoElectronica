package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MuestraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuestraApplication.class, args);
	}

	    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
