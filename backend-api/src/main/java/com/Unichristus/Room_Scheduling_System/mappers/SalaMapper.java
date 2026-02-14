package com.Unichristus.Room_Scheduling_System.mappers;

import com.Unichristus.Room_Scheduling_System.domain.dtos.sala.SalaRequestDTO;
import com.Unichristus.Room_Scheduling_System.domain.dtos.sala.SalaResponseDTO;
import com.Unichristus.Room_Scheduling_System.domain.models.Sala;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    Sala toEntity(SalaRequestDTO dto);

    SalaResponseDTO toResponseDTO(Sala sala);

}
