package com.peter.pokemon.pokemon_backend.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class PokemonApiDTO {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;
    private List<Type> types;

    @Data
    public static class Ability {
        private String name;
    }

    @Data
    public static class Type {
        private String name;
    }
}
