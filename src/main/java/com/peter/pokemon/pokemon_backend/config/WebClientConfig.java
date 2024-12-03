package com.peter.pokemon.pokemon_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://pokeapi.co/api/v2") // Substitua pela URL base da sua API
                .build();
    }
}
