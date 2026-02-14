package com.Unichristus.Room_Scheduling_System.mock;

import com.Unichristus.Room_Scheduling_System.domain.enums.StatusSala;
import com.Unichristus.Room_Scheduling_System.domain.models.Sala;
import com.Unichristus.Room_Scheduling_System.repositories.SalaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SalaMockLoader {

    private final SalaRepository salaRepository;

    @PostConstruct
    public void carregarSalasMock() {

        if (salaRepository.count() > 0) {
            return;
        }

        salaRepository.saveAll(List.of(
                Sala.builder()
                        .descricao("Sala 101")
                        .andar("1º Andar")
                        .capacidade(30)
                        .status(StatusSala.ATIVA)
                        .build(),

                Sala.builder()
                        .descricao("Sala 102")
                        .andar("1º Andar")
                        .capacidade(30)
                        .status(StatusSala.ATIVA)
                        .build(),

                Sala.builder()
                        .descricao("Sala 201")
                        .andar("2º Andar")
                        .capacidade(40)
                        .status(StatusSala.ATIVA)
                        .build(),

                Sala.builder()
                        .descricao("Sala 202")
                        .andar("2º Andar")
                        .capacidade(40)
                        .status(StatusSala.ATIVA)
                        .build(),

                Sala.builder()
                        .descricao("Laboratório 1")
                        .andar("Térreo")
                        .capacidade(20)
                        .status(StatusSala.EM_MANUTENCAO)
                        .build()
        ));
    }
}

