package com.peter.pokemon.pokemon_backend.controller;

import com.peter.pokemon.pokemon_backend.model.dto.RegiaoDTO;
import com.peter.pokemon.pokemon_backend.service.RegiaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regioes")
@RequiredArgsConstructor
@Slf4j
public class RegiaoController {

    private final RegiaoService regiaoService;

    @GetMapping
    public ResponseEntity<List<RegiaoDTO>> listarTodos() {
        log.info("Chamando listarTodos no RegiaoController");
        List<RegiaoDTO> regioes = regiaoService.listarTodos();
        return ResponseEntity.ok(regioes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegiaoDTO> buscarPorId(@PathVariable Long id) {
        log.info("Chamando buscarPorId no RegiaoController com id: {}", id);
        Optional<RegiaoDTO> regiao = regiaoService.buscarPorId(id);
        return regiao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegiaoDTO> criarRegiao(@Valid @RequestBody RegiaoDTO regiaoDTO) {
        log.info("Chamando criarRegiao no RegiaoController com dados: {}", regiaoDTO);
        RegiaoDTO regiaoCriada = regiaoService.criarRegiao(regiaoDTO);
        return ResponseEntity.ok(regiaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegiaoDTO> atualizarRegiao(@PathVariable Long id, @Valid @RequestBody RegiaoDTO regiaoDTO) {
        log.info("Chamando atualizarRegiao no RegiaoController com id: {} e dados: {}", id, regiaoDTO);
        Optional<RegiaoDTO> regiaoAtualizada = regiaoService.atualizarRegiao(id, regiaoDTO);
        return regiaoAtualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegiao(@PathVariable Long id) {
        log.info("Chamando deletarRegiao no RegiaoController com id: {}", id);
        boolean deletado = regiaoService.deletarRegiao(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
