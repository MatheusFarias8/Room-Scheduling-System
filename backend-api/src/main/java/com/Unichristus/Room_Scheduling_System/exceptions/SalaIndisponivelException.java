package com.Unichristus.Room_Scheduling_System.exceptions;

import com.Unichristus.Room_Scheduling_System.domain.enums.StatusSala;

public class SalaIndisponivelException extends RuntimeException {

    public SalaIndisponivelException(StatusSala status) {
        super("Não é possível agendar a sala pois ela está " + formatarStatus(status) + ".");
    }

    private static String formatarStatus(StatusSala status) {
        return status.name()
                .toLowerCase()
                .replace("_", " ");
    }
}
