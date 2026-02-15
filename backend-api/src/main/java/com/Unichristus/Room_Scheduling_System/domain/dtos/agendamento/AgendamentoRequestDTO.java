package com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento;

import com.Unichristus.Room_Scheduling_System.domain.enums.Horario;
import com.Unichristus.Room_Scheduling_System.domain.enums.Turno;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AgendamentoRequestDTO {

    @NotNull(message = "Sala é obrigatória")
    private UUID salaId;

    @NotNull(message = "Data é obrigatória")
    @FutureOrPresent(message = "Data não pode ser no passado")
    private LocalDate data;

    @NotNull(message = "Turno é obrigatório")
    private Turno turno;

    @NotNull(message = "Horário é obrigatório")
    private Horario horario;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    private String descricao;

}
