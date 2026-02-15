package com.Unichristus.Room_Scheduling_System.controllers;

import com.Unichristus.Room_Scheduling_System.domain.dtos.sala.SalaResponseDTO;
import com.Unichristus.Room_Scheduling_System.domain.models.Sala;
import com.Unichristus.Room_Scheduling_System.mappers.SalaMapper;
import com.Unichristus.Room_Scheduling_System.repositories.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaRepository salaRepository;
    private final SalaMapper salaMapper;

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {

        List<SalaResponseDTO> response =
                salaRepository.findAll()
                        .stream()
                        .map(salaMapper::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable UUID id) {
        return salaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
