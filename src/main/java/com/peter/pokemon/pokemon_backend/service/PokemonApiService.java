package com.peter.pokemon.pokemon_backend.service;

import com.peter.pokemon.pokemon_backend.model.dto.PokemonApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class PokemonApiService {

    private final WebClient webClient; // O bean será injetado aqui automaticamente.

    public PokemonApiDTO buscarDetalhesPokemon(String nomeOuId) {
        return webClient.get()
                .uri("/pokemon/{nomeOuId}", nomeOuId)
                .retrieve()
                .bodyToMono(PokemonApiDTO.class)
                .block();
    }
}
