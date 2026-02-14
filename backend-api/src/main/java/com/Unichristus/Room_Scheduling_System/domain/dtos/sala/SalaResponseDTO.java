package com.Unichristus.Room_Scheduling_System.domain.dtos.sala;

import lombok.Data;

import java.util.UUID;

@Data
public class SalaResponseDTO {

    private UUID id;
    private String descricao;
    private String andar;
    private Integer capacidade;
    private String status;

}
