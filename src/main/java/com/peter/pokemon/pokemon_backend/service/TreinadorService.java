package com.peter.pokemon.pokemon_backend.service;

import com.peter.pokemon.pokemon_backend.model.Treinador;
import com.peter.pokemon.pokemon_backend.model.dto.TreinadorDTO;
import com.peter.pokemon.pokemon_backend.repository.TreinadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreinadorService {

    private final TreinadorRepository treinadorRepository;

    // Listar todos os Treinadores
    public List<TreinadorDTO> listarTodos() {
        return treinadorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar Treinador por ID
    public Optional<TreinadorDTO> buscarPorId(Long id) {
        return treinadorRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Criar um novo Treinador
    public TreinadorDTO criarTreinador(TreinadorDTO treinadorDTO) {
        Treinador treinador = convertToEntity(treinadorDTO);
        return convertToDTO(treinadorRepository.save(treinador));
    }

    // Atualizar Treinador
    public Optional<TreinadorDTO> atualizarTreinador(Long id, TreinadorDTO treinadorDTO) {
        return treinadorRepository.findById(id).map(treinador -> {
            treinador.setNome(treinadorDTO.getNome());
            return convertToDTO(treinadorRepository.save(treinador));
        });
    }

    // Deletar Treinador
    public boolean deletarTreinador(Long id) {
        if (treinadorRepository.existsById(id)) {
            treinadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converter Treinador para DTO
    private TreinadorDTO convertToDTO(Treinador treinador) {
        return new TreinadorDTO(treinador.getId(), treinador.getNome(), new Integer (1));
    }

    // Converter DTO para Treinador
    private Treinador convertToEntity(TreinadorDTO treinadorDTO) {
        Treinador treinador = new Treinador();
        treinador.setId(treinadorDTO.getId());
        treinador.setNome(treinadorDTO.getNome());
        return treinador;
    }
}
