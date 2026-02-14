package com.Unichristus.Room_Scheduling_System.domain.dtos.sala;

import lombok.Data;

@Data
public class SalaRequestDTO {

    private String descricao;
    private String andar;
    private Integer capacidade;
    private String status;

}
