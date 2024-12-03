package com.peter.pokemon.pokemon_backend.repository;

import com.peter.pokemon.pokemon_backend.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  // Adicionando a importação de List

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    // Método para buscar Time por nome
    List<Time> findByNomeContaining(String nome);
}
