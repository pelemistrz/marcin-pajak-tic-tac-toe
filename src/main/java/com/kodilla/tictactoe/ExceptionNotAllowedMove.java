package com.kodilla.tictactoe;

public class ExceptionNotAllowedMove extends RuntimeException{
    public ExceptionNotAllowedMove(String message) {
        super(message);
    }
}
