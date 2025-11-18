package com.example.mentalhealth.service;

import com.example.mentalhealth.dto.PacienteRequestDTO;
import com.example.mentalhealth.dto.PacienteResponseDTO;

import java.util.List;

public interface PacienteService {
    List<PacienteResponseDTO> findAll();
    PacienteResponseDTO findById(Long id);
    PacienteResponseDTO create(PacienteRequestDTO dto);
    PacienteResponseDTO update(Long id, PacienteRequestDTO dto);
    void delete(Long id);
}
