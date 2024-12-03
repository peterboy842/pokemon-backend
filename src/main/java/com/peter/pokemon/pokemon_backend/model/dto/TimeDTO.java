package com.peter.pokemon.pokemon_backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDTO {

    private Long id;

    @NotNull(message = "Nome do Time não pode ser nulo")
    @Size(min = 1, max = 100, message = "Nome do Time deve ter entre 1 e 100 caracteres")
    private String nome;

    @NotNull(message = "ID do Treinador não pode ser nulo")
    private Long treinadorId;  // Usando o ID do Treinador para simplificar

    // Adicione aqui mais campos de acordo com a estrutura do seu Time, como IDs de Pokémon, etc.
}
