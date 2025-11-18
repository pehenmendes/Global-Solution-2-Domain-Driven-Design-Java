package com.example.mentalhealth.service.impl;

import com.example.mentalhealth.dto.RegistroDiarioRequestDTO;
import com.example.mentalhealth.dto.RegistroDiarioResponseDTO;
import com.example.mentalhealth.entity.Paciente;
import com.example.mentalhealth.entity.RegistroDiario;
import com.example.mentalhealth.exception.ResourceNotFoundException;
import com.example.mentalhealth.mapper.RegistroDiarioMapper;
import com.example.mentalhealth.repository.PacienteRepository;
import com.example.mentalhealth.repository.RegistroDiarioRepository;
import com.example.mentalhealth.service.RegistroDiarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroDiarioServiceImpl implements RegistroDiarioService {

    private final RegistroDiarioRepository registroRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;
    private final RegistroDiarioMapper registroDiarioMapper;

    public RegistroDiarioServiceImpl(RegistroDiarioRepository registroRepository,
                                     PacienteRepository pacienteRepository,
                                     ModelMapper modelMapper,
                                     RegistroDiarioMapper registroDiarioMapper) {
        this.registroRepository = registroRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        this.registroDiarioMapper = registroDiarioMapper;
    }

    @Override
    public List<RegistroDiarioResponseDTO> findAll() {
        return registroRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RegistroDiarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistroDiarioResponseDTO findById(Long id) {
        RegistroDiario reg = registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistroDiario não encontrado com id: " + id));
        return modelMapper.map(reg, RegistroDiarioResponseDTO.class);
    }

    @Override
    public RegistroDiarioResponseDTO create(RegistroDiarioRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));

        RegistroDiario reg = new RegistroDiario();
        reg.setPaciente(paciente);
        reg.setDataRegistro(dto.getDataRegistro());
        reg.setNivelHumor(dto.getNivelHumor());
        reg.setObservacoes(dto.getObservacoes());

        RegistroDiario saved = registroRepository.save(reg);
        return modelMapper.map(saved, RegistroDiarioResponseDTO.class);
    }

    @Override
    public RegistroDiarioResponseDTO update(Long id, RegistroDiarioRequestDTO dto) {
        RegistroDiario existing = registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistroDiario não encontrado com id: " + id));

        if (!existing.getPaciente().getId().equals(dto.getPacienteId())) {
            // validar existência do novo paciente
            Paciente newPaciente = pacienteRepository.findById(dto.getPacienteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + dto.getPacienteId()));
            existing.setPaciente(newPaciente);
        }

        existing.setDataRegistro(dto.getDataRegistro());
        existing.setNivelHumor(dto.getNivelHumor());
        existing.setObservacoes(dto.getObservacoes());

        RegistroDiario updated = registroRepository.save(existing);
        return registroDiarioMapper.toResponseDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!registroRepository.existsById(id)) {
            throw new ResourceNotFoundException("RegistroDiario não encontrado com id: " + id);
        }
        registroRepository.deleteById(id);
    }

    @Override
    public List<RegistroDiarioResponseDTO> findByPacienteId(Long pacienteId) {
        return registroRepository.findByPacienteId(pacienteId)
                .stream()
                .map(r -> modelMapper.map(r, RegistroDiarioResponseDTO.class))
                .collect(Collectors.toList());
    }
}