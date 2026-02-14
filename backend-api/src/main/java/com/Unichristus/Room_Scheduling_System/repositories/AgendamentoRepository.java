package com.Unichristus.Room_Scheduling_System.repositories;

import com.Unichristus.Room_Scheduling_System.domain.enums.Horario;
import com.Unichristus.Room_Scheduling_System.domain.enums.Turno;
import com.Unichristus.Room_Scheduling_System.domain.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {

    boolean existsBySala_IdAndDataAndTurnoAndHorario(
            UUID salaId,
            LocalDate data,
            Turno turno,
            Horario horario
    );

    boolean existsBySala_IdAndDataAndTurnoAndHorarioAndIdNot(
            UUID salaId,
            LocalDate data,
            Turno turno,
            Horario horario,
            UUID id
    );
}
