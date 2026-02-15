package com.Unichristus.Room_Scheduling_System.services;

import com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento.AgendamentoRequestDTO;
import com.Unichristus.Room_Scheduling_System.domain.dtos.agendamento.AgendamentoResponseDTO;
import com.Unichristus.Room_Scheduling_System.domain.enums.StatusSala;
import com.Unichristus.Room_Scheduling_System.domain.models.Agendamento;
import com.Unichristus.Room_Scheduling_System.domain.models.Sala;
import com.Unichristus.Room_Scheduling_System.exceptions.AgendamentoNotFoundException;
import com.Unichristus.Room_Scheduling_System.exceptions.ConflitoAgendamentoException;
import com.Unichristus.Room_Scheduling_System.exceptions.SalaIndisponivelException;
import com.Unichristus.Room_Scheduling_System.exceptions.SalaNotFoundException;
import com.Unichristus.Room_Scheduling_System.mappers.AgendamentoMapper;
import com.Unichristus.Room_Scheduling_System.repositories.AgendamentoRepository;
import com.Unichristus.Room_Scheduling_System.repositories.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoMapper mapper;
    private final SalaRepository salaRepository;

    public List<AgendamentoResponseDTO> listarTodos() {
        return agendamentoRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public AgendamentoResponseDTO buscarPorId(UUID id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new AgendamentoNotFoundException(id));

        return mapper.toResponseDTO(agendamento);
    }

    public AgendamentoResponseDTO criar(AgendamentoRequestDTO dto) {

        validarConflito(dto, null);

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new SalaNotFoundException(dto.getSalaId()));

        if (sala.getStatus() != StatusSala.ATIVA) {
            throw new SalaIndisponivelException(sala.getStatus());
        }

        Agendamento agendamento = mapper.toEntity(dto);
        agendamento.setSala(sala);

        Agendamento salvo = agendamentoRepository.save(agendamento);

        return mapper.toResponseDTO(salvo);
    }

    public AgendamentoResponseDTO atualizar(UUID id, AgendamentoRequestDTO dto) {

        Agendamento existente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new AgendamentoNotFoundException(id));

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new SalaNotFoundException(dto.getSalaId()));

        if (sala.getStatus() != StatusSala.ATIVA) {
            throw new SalaIndisponivelException(sala.getStatus());
        }

        validarConflito(dto, id);

        existente.setData(dto.getData());
        existente.setTurno(dto.getTurno());
        existente.setHorario(dto.getHorario());
        existente.setDescricao(dto.getDescricao());
        existente.setSala(sala);

        Agendamento atualizado = agendamentoRepository.save(existente);

        return mapper.toResponseDTO(atualizado);
    }

    public void deletar(UUID id) {

        if (!agendamentoRepository.existsById(id)) {
            throw new AgendamentoNotFoundException(id);
        }

        agendamentoRepository.deleteById(id);
    }

    private void validarConflito(AgendamentoRequestDTO dto, UUID id) {

        boolean existe;

        if (id == null) {
            existe = agendamentoRepository.existsBySala_IdAndDataAndTurnoAndHorario(
                    dto.getSalaId(),
                    dto.getData(),
                    dto.getTurno(),
                    dto.getHorario()
            );
        } else {
            existe = agendamentoRepository.existsBySala_IdAndDataAndTurnoAndHorarioAndIdNot(
                    dto.getSalaId(),
                    dto.getData(),
                    dto.getTurno(),
                    dto.getHorario(),
                    id
            );
        }

        if (existe) {
            throw new ConflitoAgendamentoException();
        }
    }
}
