package com.Unichristus.Room_Scheduling_System.exceptions;

import java.util.UUID;

public class SalaNotFoundException extends RuntimeException {

    public SalaNotFoundException(UUID id) {
        super("Sala com ID " + id + " não encontrada");
    }

}
