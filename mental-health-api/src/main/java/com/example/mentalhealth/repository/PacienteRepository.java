package com.example.mentalhealth.repository;

import com.example.mentalhealth.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}
