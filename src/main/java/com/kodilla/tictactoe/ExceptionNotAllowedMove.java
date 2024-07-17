package com.kodilla.tictactoe;

public class ExceptionNotAllowedMove extends Exception{
    public ExceptionNotAllowedMove(String message) {
        super(message);
    }
}
