package com.peter.pokemon.pokemon_backend.controller;

import com.peter.pokemon.pokemon_backend.model.dto.PokemonDTO;
import com.peter.pokemon.pokemon_backend.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
@RequiredArgsConstructor
@Slf4j
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> listarTodos() {
        log.info("Chamando listarTodos no PokemonController");
        List<PokemonDTO> pokemons = pokemonService.listarTodos();
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no PokemonController com id: {}", id);
        return pokemonService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PokemonDTO> criarPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {
        log.info("Chamando criarPokemon no PokemonController com dados: {}", pokemonDTO);
        PokemonDTO pokemonCriado = pokemonService.criarPokemon(pokemonDTO);
        return ResponseEntity.ok(pokemonCriado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PokemonDTO> atualizarPokemon(@PathVariable Long id, @Valid @RequestBody PokemonDTO pokemonDTO) {
        log.info("Chamando atualizarPokemon no PokemonController com id: {} e dados: {}", id, pokemonDTO);

        try {
            PokemonDTO pokemonAtualizado = pokemonService.atualizarPokemon(id, pokemonDTO);
            return ResponseEntity.ok(pokemonAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // Caso o Pokémon não seja encontrado
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPokemon(@PathVariable Long id) {
        log.info("Chamando deletarPokemon no PokemonController com id: {}", id);
        boolean deletado = pokemonService.deletarPokemon(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
