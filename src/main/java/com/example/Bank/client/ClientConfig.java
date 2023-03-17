package com.example.Bank.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            Client kobe = new Client("Kobe","Celen",222L,1000);
            Client alex = new Client("Alex","Celen",555L,2000);

            clientRepository.saveAll(List.of(kobe,alex));
        };
    }
}
