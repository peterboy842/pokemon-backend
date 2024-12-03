package com.peter.pokemon.pokemon_backend.controller;

import com.peter.pokemon.pokemon_backend.model.dto.PokemonApiDTO;
import com.peter.pokemon.pokemon_backend.service.PokemonApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemons")
@RequiredArgsConstructor
public class PokemonApiController {

    private final PokemonApiService pokemonApiService;

    @GetMapping("/{nomeOuId}")
    public PokemonApiDTO buscarPokemon(@PathVariable String nomeOuId) {
        return pokemonApiService.buscarDetalhesPokemon(nomeOuId);
    }
}
