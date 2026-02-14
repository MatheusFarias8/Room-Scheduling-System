package com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento;

import com.Unichristus.Room_Scheduling_System.domain.enums.Horario;
import com.Unichristus.Room_Scheduling_System.domain.enums.Turno;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AgendamentoRequestDTO {

    private UUID salaId;
    private LocalDate data;
    private Turno turno;
    private Horario horario;
    private String descricao;

}
