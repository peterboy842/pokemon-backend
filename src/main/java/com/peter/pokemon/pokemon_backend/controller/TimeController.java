package com.peter.pokemon.pokemon_backend.controller;

import com.peter.pokemon.pokemon_backend.model.dto.TimeDTO;
import com.peter.pokemon.pokemon_backend.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
@RequiredArgsConstructor
@Slf4j
public class TimeController {

    private final TimeService timeService;

    @GetMapping
    public ResponseEntity<List<TimeDTO>> listarTodos() {
        log.info("Chamando listarTodos no TimeController");
        List<TimeDTO> times = timeService.listarTodos();
        return ResponseEntity.ok(times);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no TimeController com id: {}", id);
        Optional<TimeDTO> time = timeService.buscarPorId(id);
        return time.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TimeDTO> criarTime(@Valid @RequestBody TimeDTO timeDTO) {
        log.info("Chamando criarTime no TimeController com dados: {}", timeDTO);
        TimeDTO timeCriado = timeService.criarTime(timeDTO);
        return ResponseEntity.ok(timeCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeDTO> atualizarTime(@PathVariable Long id, @Valid @RequestBody TimeDTO timeDTO) {
        log.info("Chamando atualizarTime no TimeController com id: {} e dados: {}", id, timeDTO);
        Optional<TimeDTO> timeAtualizado = timeService.atualizarTime(id, timeDTO);
        return timeAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTime(@PathVariable Long id) {
        log.info("Chamando deletarTime no TimeController com id: {}", id);
        boolean deletado = timeService.deletarTime(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
