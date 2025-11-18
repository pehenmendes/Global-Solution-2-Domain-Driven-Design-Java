package com.example.mentalhealth.service;

import com.example.mentalhealth.dto.RegistroDiarioRequestDTO;
import com.example.mentalhealth.dto.RegistroDiarioResponseDTO;

import java.util.List;

public interface RegistroDiarioService {
    List<RegistroDiarioResponseDTO> findAll();
    RegistroDiarioResponseDTO findById(Long id);
    RegistroDiarioResponseDTO create(RegistroDiarioRequestDTO dto);
    RegistroDiarioResponseDTO update(Long id, RegistroDiarioRequestDTO dto);
    void delete(Long id);
    List<RegistroDiarioResponseDTO> findByPacienteId(Long pacienteId);
}
