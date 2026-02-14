package com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AgendamentoRequestDTO {

    private UUID salaId;
    private LocalDate data;
    private Integer turno;
    private Integer horario;
    private String descricao;

}
