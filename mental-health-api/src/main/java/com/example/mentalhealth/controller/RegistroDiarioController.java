package com.example.mentalhealth.controller;

import com.example.mentalhealth.dto.RegistroDiarioRequestDTO;
import com.example.mentalhealth.dto.RegistroDiarioResponseDTO;
import com.example.mentalhealth.service.RegistroDiarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroDiarioController {

    private final RegistroDiarioService registroService;

    public RegistroDiarioController(RegistroDiarioService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroDiarioResponseDTO>> getAll() {
        return ResponseEntity.ok(registroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.findById(id));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<RegistroDiarioResponseDTO>> getByPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(registroService.findByPacienteId(pacienteId));
    }

    @PostMapping
    public ResponseEntity<RegistroDiarioResponseDTO> create(@Valid @RequestBody RegistroDiarioRequestDTO dto) {
        RegistroDiarioResponseDTO created = registroService.create(dto);
        return ResponseEntity.created(URI.create("/api/registros/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> update(@PathVariable Long id, @Valid @RequestBody RegistroDiarioRequestDTO dto) {
        return ResponseEntity.ok(registroService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        registroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}