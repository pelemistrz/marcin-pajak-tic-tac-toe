package com.kodilla.tictactoe;

import java.util.Random;

public class Computer {
    private final int sizeOfBoard;
    private final int levelOfComputer;

    public Computer(int sizeOfBoard, int levelOfComputer) {
        this.sizeOfBoard = sizeOfBoard;
        this.levelOfComputer = levelOfComputer;
    }
    public int computerMove(int[][] board) {
        Random rand = new Random();
        int move;
        int row;
        int col;
        do{
            move = rand.nextInt(sizeOfBoard*sizeOfBoard-1)+1;
            row = (int) (move-1)/sizeOfBoard;
            col =  (move-1)%sizeOfBoard;
        }
        while(board[row][col]!=0);
        return move;
    }
}
