package com.Unichristus.Room_Scheduling_System.domain.models;

import com.Unichristus.Room_Scheduling_System.domain.enums.StatusSala;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;

    private String andar;

    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private StatusSala status;
}
