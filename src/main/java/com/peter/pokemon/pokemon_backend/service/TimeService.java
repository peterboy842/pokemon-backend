package com.peter.pokemon.pokemon_backend.service;

import com.peter.pokemon.pokemon_backend.model.Time;
import com.peter.pokemon.pokemon_backend.model.dto.TimeDTO;
import com.peter.pokemon.pokemon_backend.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;

    // Listar todos os Times
    public List<TimeDTO> listarTodos() {
        return timeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar Time por ID
    public Optional<TimeDTO> buscarPorId(Long id) {
        return timeRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Criar um novo Time
    public TimeDTO criarTime(TimeDTO timeDTO) {
        Time time = convertToEntity(timeDTO);
        return convertToDTO(timeRepository.save(time));
    }

    // Atualizar Time
    public Optional<TimeDTO> atualizarTime(Long id, TimeDTO timeDTO) {
        return timeRepository.findById(id).map(time -> {
            time.setNome(timeDTO.getNome());
            return convertToDTO(timeRepository.save(time));
        });
    }

    // Deletar Time
    public boolean deletarTime(Long id) {
        if (timeRepository.existsById(id)) {
            timeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Converter Time para DTO
    private TimeDTO convertToDTO(Time time) {
        return new TimeDTO(time.getId(), time.getNome(), new Long(2));
    }

    // Converter DTO para Time
    private Time convertToEntity(TimeDTO timeDTO) {
        Time time = new Time();
        time.setId(timeDTO.getId());
        time.setNome(timeDTO.getNome());
        return time;
    }
}
