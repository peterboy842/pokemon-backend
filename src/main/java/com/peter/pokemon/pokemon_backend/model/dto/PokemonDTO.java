package com.peter.pokemon.pokemon_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {

    private Long id;

    @NotNull(message = "Nome do Pokémon não pode ser nulo")
    @Size(min = 1, max = 100, message = "Nome do Pokémon deve ter entre 1 e 100 caracteres")
    private String nome;

    @NotNull(message = "Tipo do Pokémon não pode ser nulo")
    @Size(min = 1, max = 50, message = "Tipo do Pokémon deve ter entre 1 e 50 caracteres")
    private String tipo;

    @Min(value = 1, message = "Nível deve ser maior ou igual a 1")
    private int nivel;

    private Long regiaoId;  // Usando o ID da região para simplificar
    private Long timeId;    // Usando o ID do time para simplificar
}
