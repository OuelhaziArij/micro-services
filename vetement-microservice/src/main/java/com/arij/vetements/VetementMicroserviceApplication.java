package com.arij.vetements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VetementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetementMicroserviceApplication.class, args);
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
