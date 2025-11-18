package com.example.mentalhealth.dto;

import java.time.LocalDate;

public class RegistroDiarioResponseDTO {
    private Long id;
    private Long pacienteId;
    private LocalDate dataRegistro;
    private int nivelHumor;
    private String observacoes;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
    public int getNivelHumor() { return nivelHumor; }
    public void setNivelHumor(int nivelHumor) { this.nivelHumor = nivelHumor; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
