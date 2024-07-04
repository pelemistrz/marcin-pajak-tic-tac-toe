package com.kodilla.tictactoe;

public class Board {
    int[] board = new int[9];
    int moveOfPlayer = 1;

    public Board() {
        for (int i = 0; i < 9; i++) {
            this.board[i] = -2;
        }
    }

    public void changeBoard(int move) {
        if (moveOfPlayer == 1) {
            board[move - 1] = 1;
        } else {
            board[move - 1] = 2;
        }
    }

    public int[] getBoard() {
        return board;
    }

    public int getMoveOfPlayer() {
        return moveOfPlayer;
    }

    public void setMoveOfPlayer(int moveOfPlayer) {
        this.moveOfPlayer = moveOfPlayer;
    }
}

