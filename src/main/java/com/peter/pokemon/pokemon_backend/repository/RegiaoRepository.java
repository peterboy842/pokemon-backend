package com.peter.pokemon.pokemon_backend.repository;

import com.peter.pokemon.pokemon_backend.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;  // Adicionando a importação de List

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
    // Método para buscar Região por nome
    List<Regiao> findByNomeContaining(String nome);
}
