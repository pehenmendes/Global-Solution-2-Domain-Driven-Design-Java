package com.example.mentalhealth.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RegistroDiarioRequestDTO {
    @NotNull
    private Long pacienteId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRegistro;
    @Min(1) @Max(5)
    private int nivelHumor;
    private String observacoes;

    // getters and setters
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }
    public int getNivelHumor() { return nivelHumor; }
    public void setNivelHumor(int nivelHumor) { this.nivelHumor = nivelHumor; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
