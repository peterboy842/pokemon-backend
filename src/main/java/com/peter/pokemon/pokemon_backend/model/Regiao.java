package com.peter.pokemon.pokemon_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "regiao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons; // Uma Região contém vários Pokémons

    @OneToMany(mappedBy = "regiaonatal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treinador> treinadores; // Uma Região contém vários treinadores
}
