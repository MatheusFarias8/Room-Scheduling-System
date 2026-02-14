package com.Unichristus.Room_Scheduling_System.exceptions;

import java.util.UUID;

public class AgendamentoNotFoundException extends RuntimeException {

    public AgendamentoNotFoundException(UUID id) {
        super("Agendamento com ID " + id + " não encontrado");
    }
}

