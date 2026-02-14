package com.Unichristus.Room_Scheduling_System.mappers;

import com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento.AgendamentoRequestDTO;
import com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento.AgendamentoResponseDTO;
import com.Unichristus.Room_Scheduling_System.domain.models.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {

    @Mapping(source = "sala.id", target = "salaId")
    AgendamentoResponseDTO toResponseDTO(Agendamento agendamento);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sala", ignore = true)
    Agendamento toEntity(AgendamentoRequestDTO dto);

}
