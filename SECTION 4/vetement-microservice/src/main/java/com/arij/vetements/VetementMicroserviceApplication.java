package com.arij.vetements;

import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VetementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetementMicroserviceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    CommandLineRunner commandLineRunner(VetementRepository vetementRepository) {
        return args -> {
            vetementRepository.save(Vetement.builder()
                    .Name("Robe")
                    .Marque("Zara")
                    .colCode("ETE")
                    .build());
        };
    }
}