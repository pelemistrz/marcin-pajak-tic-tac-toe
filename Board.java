package com.kodilla.tictactoe;

public class Board {
    int sizeBoard;
    int[][] board;
    int moveOfPlayer = 1;
    int howManyMovesHasBeenMade = 0;

    public Board(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        this.board = new int[sizeBoard][sizeBoard];
        for (int i = 0; i < sizeBoard; i++) {
            for(int j = 0; j < sizeBoard; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    public void checkMove(int move) throws ExceptionNotAllowedMove{
        int row = (int) (move-1)/sizeBoard;
        int col =  (move-1)%sizeBoard;
        if (move<1 || move>sizeBoard*sizeBoard || board[row][col] == 1 || board[row][col] == -1) {
            throw new ExceptionNotAllowedMove("Please enter move which is in range and not taken\n");
        }
    }

    public void makeMove(int move) {
        int row = (int) (move-1)/sizeBoard;
        int col =  (move-1)%sizeBoard;
        if (moveOfPlayer == 2) {
            board[row][col] = -1;
        } else {
            board[row][col] = 1;
        }
        howManyMovesHasBeenMade++;
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

    public int getHowManyMovesHasBeenMade() {
        return howManyMovesHasBeenMade;
    }

    public void setMoveOfPlayer(int moveOfPlayer) {
        this.moveOfPlayer = moveOfPlayer;
    }

}

