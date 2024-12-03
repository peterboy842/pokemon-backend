package com.peter.pokemon.pokemon_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private int nivel;

    @ManyToOne
    private Regiao regiao; // Relacionamento com a região natal

    @ManyToOne
    private Time time; // Relacionamento com o time do Pokémon
}
