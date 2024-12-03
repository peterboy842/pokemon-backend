package com.peter.pokemon.pokemon_backend.controller;

import com.peter.pokemon.pokemon_backend.model.dto.TreinadorDTO;
import com.peter.pokemon.pokemon_backend.service.TreinadorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinadores")
@RequiredArgsConstructor
@Slf4j
public class TreinadorController {

    private final TreinadorService treinadorService;

    @GetMapping
    public ResponseEntity<List<TreinadorDTO>> listarTodos() {
        log.info("Chamando listarTodos no TreinadorController");
        List<TreinadorDTO> treinadores = treinadorService.listarTodos();
        return ResponseEntity.ok(treinadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinadorDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no TreinadorController com id: {}", id);
        Optional<TreinadorDTO> treinador = treinadorService.buscarPorId(id);
        return treinador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TreinadorDTO> criarTreinador(@Valid @RequestBody TreinadorDTO treinadorDTO) {
        log.info("Chamando criarTreinador no TreinadorController com dados: {}", treinadorDTO);
        TreinadorDTO treinadorCriado = treinadorService.criarTreinador(treinadorDTO);
        return ResponseEntity.ok(treinadorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinadorDTO> atualizarTreinador(@PathVariable Long id, @Valid @RequestBody TreinadorDTO treinadorDTO) {
        log.info("Chamando atualizarTreinador no TreinadorController com id: {} e dados: {}", id, treinadorDTO);
        Optional<TreinadorDTO> treinadorAtualizado = treinadorService.atualizarTreinador(id, treinadorDTO);
        return treinadorAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTreinador(@PathVariable Long id) {
        log.info("Chamando deletarTreinador no TreinadorController com id: {}", id);
        boolean deletado = treinadorService.deletarTreinador(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
