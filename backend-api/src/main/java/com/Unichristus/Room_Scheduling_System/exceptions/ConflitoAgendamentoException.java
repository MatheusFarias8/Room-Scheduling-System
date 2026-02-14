package com.Unichristus.Room_Scheduling_System.exceptions;

public class ConflitoAgendamentoException extends RuntimeException {

    public ConflitoAgendamentoException() {
        super("Já existe agendamento para essa sala nesse horário");
    }
}

