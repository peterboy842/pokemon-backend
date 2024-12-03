package com.peter.pokemon.pokemon_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreinadorDTO {

    private Long id;

    @NotNull(message = "Nome do treinador não pode ser nulo")
    @Size(min = 1, max = 100, message = "Nome do treinador deve ter entre 1 e 100 caracteres")
    private String nome;

    @NotNull(message = "Idade do treinador não pode ser nula")
    private Integer idade;
}
