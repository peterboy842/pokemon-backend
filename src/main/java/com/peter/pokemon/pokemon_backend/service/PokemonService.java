package com.peter.pokemon.pokemon_backend.service;

import com.peter.pokemon.pokemon_backend.model.Pokemon;
import com.peter.pokemon.pokemon_backend.model.dto.PokemonDTO;
import com.peter.pokemon.pokemon_backend.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    // Listar todos os Pokémons
    public List<PokemonDTO> listarTodos() {
        return pokemonRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar Pokémon por ID
    public Optional<PokemonDTO> buscarPorId(Long id) {
        return pokemonRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Criar um novo Pokémon
    public PokemonDTO criarPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = convertToEntity(pokemonDTO);
        return convertToDTO(pokemonRepository.save(pokemon));
    }

    // Atualizar Pokémon
    public PokemonDTO atualizarPokemon(Long id, PokemonDTO pokemonDTO) {
        return pokemonRepository.findById(id).map(pokemon -> {
            pokemon.setNome(pokemonDTO.getNome());
            pokemon.setTipo(pokemonDTO.getTipo());
            pokemon.setNivel(pokemonDTO.getNivel());
            // Atribuindo a região e o time com base no ID
            return convertToDTO(pokemonRepository.save(pokemon));
        }).orElseThrow(() -> new RuntimeException("Pokémon não encontrado"));
    }


    // Deletar Pokémon
    public boolean deletarPokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converter de Pokemon para PokemonDTO
    private PokemonDTO convertToDTO(Pokemon pokemon) {
        return new PokemonDTO(
                pokemon.getId(),
                pokemon.getNome(),
                pokemon.getTipo(),
                pokemon.getNivel(),
                pokemon.getRegiao() != null ? pokemon.getRegiao().getId() : null,  // Extraindo o ID da Regiao
                pokemon.getTime() != null ? pokemon.getTime().getId() : null        // Extraindo o ID do Time
        );
    }

    // Converter de PokemonDTO para Pokemon (se necessário)
    private Pokemon convertToEntity(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDTO.getId());
        pokemon.setNome(pokemonDTO.getNome());
        pokemon.setTipo(pokemonDTO.getTipo());
        pokemon.setNivel(pokemonDTO.getNivel());
        // Aqui você pode adicionar a lógica para definir a Regiao e Time se necessário, usando os IDs
        return pokemon;
    }
}
