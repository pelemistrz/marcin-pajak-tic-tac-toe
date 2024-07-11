package com.kodilla.tictactoe;

public class Board {
    int sizeBoard;
    int[][] board;
    int moveOfPlayer = 1;

    public Board(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        this.board = new int[sizeBoard][sizeBoard];
        for (int i = 0; i < sizeBoard; i++) {
            for(int j = 0; j < sizeBoard; j++) {
                this.board[i][j] = 0;

            }
        }
    }

    public void changeBoard(int move) {
        int row = (int) (move-1)/sizeBoard;
        int col =  (move-1)%sizeBoard;
        if (moveOfPlayer == 2) {

            board[row][col] = -1;
        } else {
            board[row][col] = 1;
        }
    }

    public int getSizeBoard() {
        return sizeBoard;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getMoveOfPlayer() {
        return moveOfPlayer;
    }

    public void setMoveOfPlayer(int moveOfPlayer) {
        this.moveOfPlayer = moveOfPlayer;
    }
}

