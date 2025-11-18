package com.example.mentalhealth.mapper;

import com.example.mentalhealth.dto.PacienteRequestDTO;
import com.example.mentalhealth.dto.PacienteResponseDTO;
import com.example.mentalhealth.entity.Paciente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    private final ModelMapper modelMapper;

    public PacienteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Paciente toEntity(PacienteRequestDTO dto) {
        return modelMapper.map(dto, Paciente.class);
    }

    public void updateEntityFromDto(PacienteRequestDTO dto, Paciente entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setDataNascimento(dto.getDataNascimento());
    }

    public PacienteResponseDTO toResponseDTO(Paciente entity) {
        return modelMapper.map(entity, PacienteResponseDTO.class);
    }
}