package com.peter.pokemon.pokemon_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "treinador")
    private List<Time> times; // Relacionamento com os times do treinador

    @ManyToOne
    private Regiao regiaonatal; // Relacionamento com a região natal
}
