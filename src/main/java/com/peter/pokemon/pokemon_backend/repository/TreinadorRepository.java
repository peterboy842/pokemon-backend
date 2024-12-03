package com.peter.pokemon.pokemon_backend.repository;

import com.peter.pokemon.pokemon_backend.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  // Adicionando a importação de List

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
    // Método para buscar Treinador por nome
    List<Treinador> findByNomeContaining(String nome);
}
