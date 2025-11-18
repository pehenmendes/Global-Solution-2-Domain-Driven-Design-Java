package com.example.mentalhealth.service.impl;

import com.example.mentalhealth.dto.PacienteRequestDTO;
import com.example.mentalhealth.dto.PacienteResponseDTO;
import com.example.mentalhealth.entity.Paciente;
import com.example.mentalhealth.exception.ResourceNotFoundException;
import com.example.mentalhealth.repository.PacienteRepository;
import com.example.mentalhealth.service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PacienteResponseDTO> findAll() {
        return pacienteRepository.findAll()
                                 .stream()
                                 .map(p -> modelMapper.map(p, PacienteResponseDTO.class))
                                 .collect(Collectors.toList());
    }

    @Override
    public PacienteResponseDTO findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + id));
        return modelMapper.map(paciente, PacienteResponseDTO.class);
    }

    @Override
    public PacienteResponseDTO create(PacienteRequestDTO dto) {
        Paciente paciente = modelMapper.map(dto, Paciente.class);
        Paciente saved = pacienteRepository.save(paciente);
        return modelMapper.map(saved, PacienteResponseDTO.class);
    }

    @Override
    public PacienteResponseDTO update(Long id, PacienteRequestDTO dto) {
        Paciente existing = pacienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id: " + id));


        // atualizar campos relevantes
        existing.setNome(dto.getNome());
        existing.setEmail(dto.getEmail());
        existing.setDataNascimento(dto.getDataNascimento());


        Paciente updated = pacienteRepository.save(existing);
        return modelMapper.map(updated, PacienteResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com id: " + id);
        }
        pacienteRepository.deleteById(id);
    }
}
