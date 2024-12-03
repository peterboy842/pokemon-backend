package com.peter.pokemon.pokemon_backend.repository;

import com.peter.pokemon.pokemon_backend.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  // Adicionando a importação de List

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    // Método para buscar Pokémon por nome
    List<Pokemon> findByNomeContaining(String nome);
}
