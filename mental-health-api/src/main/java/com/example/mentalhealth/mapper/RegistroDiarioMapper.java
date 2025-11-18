package com.example.mentalhealth.mapper;

import com.example.mentalhealth.dto.RegistroDiarioResponseDTO;
import com.example.mentalhealth.entity.RegistroDiario;
import org.springframework.stereotype.Component;

@Component
public class RegistroDiarioMapper {

    public RegistroDiarioResponseDTO toResponseDTO(RegistroDiario entity) {
        RegistroDiarioResponseDTO dto = new RegistroDiarioResponseDTO();
        dto.setId(entity.getId());
        dto.setPacienteId(entity.getPaciente().getId());
        dto.setDataRegistro(entity.getDataRegistro());
        dto.setNivelHumor(entity.getNivelHumor());
        dto.setObservacoes(entity.getObservacoes());
        return dto;
    }
}