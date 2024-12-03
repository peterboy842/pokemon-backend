package com.peter.pokemon.pokemon_backend.service;

import com.peter.pokemon.pokemon_backend.model.Regiao;
import com.peter.pokemon.pokemon_backend.model.dto.RegiaoDTO;
import com.peter.pokemon.pokemon_backend.repository.RegiaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegiaoService {

    private final RegiaoRepository regiaoRepository;

    // Listar todas as Regiões
    public List<RegiaoDTO> listarTodos() {
        return regiaoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar Região por ID
    public Optional<RegiaoDTO> buscarPorId(Long id) {
        return regiaoRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Criar uma nova Região
    public RegiaoDTO criarRegiao(RegiaoDTO regiaoDTO) {
        Regiao regiao = convertToEntity(regiaoDTO);
        return convertToDTO(regiaoRepository.save(regiao));
    }

    // Atualizar Região
    public Optional<RegiaoDTO> atualizarRegiao(Long id, RegiaoDTO regiaoDTO) {
        return regiaoRepository.findById(id).map(regiao -> {
            regiao.setNome(regiaoDTO.getNome());
            return convertToDTO(regiaoRepository.save(regiao));
        });
    }

    // Deletar Região
    public boolean deletarRegiao(Long id) {
        if (regiaoRepository.existsById(id)) {
            regiaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converter Região para DTO
    private RegiaoDTO convertToDTO(Regiao regiao) {
        return new RegiaoDTO(regiao.getId(), regiao.getNome());
    }

    // Converter DTO para Região
    private Regiao convertToEntity(RegiaoDTO regiaoDTO) {
        Regiao regiao = new Regiao();
        regiao.setId(regiaoDTO.getId());
        regiao.setNome(regiaoDTO.getNome());
        return regiao;
    }
}
