package com.Unichristus.Room_Scheduling_System.domain.models;

import com.Unichristus.Room_Scheduling_System.domain.enums.Horario;
import com.Unichristus.Room_Scheduling_System.domain.enums.Turno;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        name = "agendamento",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"sala_id", "data", "turno", "horario"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Enumerated(EnumType.STRING)
    private Horario horario;

    private String descricao;
}
