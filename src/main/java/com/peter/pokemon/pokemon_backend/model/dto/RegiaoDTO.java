package com.peter.pokemon.pokemon_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegiaoDTO {

    private Long id;

    @NotNull(message = "Nome da região não pode ser nulo")
    @Size(min = 1, max = 100, message = "Nome da região deve ter entre 1 e 100 caracteres")
    private String nome;
}
