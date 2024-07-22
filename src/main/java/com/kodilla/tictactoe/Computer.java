package com.kodilla.tictactoe;


import java.util.Random;

public class Computer {
    private final int sizeOfBoard;
    int opponent = 1, player = -1;


    public Computer(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public int computerMove(int[][] board) {
        Random rand = new Random();
        int move;
        int row;
        int col;
        do {
            move = rand.nextInt(sizeOfBoard * sizeOfBoard - 1) + 1;
            row = (int) (move - 1) / sizeOfBoard;
            col = (move - 1) % sizeOfBoard;
        }
        while (board[row][col] != 0);
        return move;
    }

    private Boolean isMovesLeft(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private int evaluate(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
                if(board[i][0]==player){
                    return 10;
                } else if(board[i][0]==opponent){
                    return -10;
                }
            }
        }

        for(int j = 0; j < 3; j++) {
            if(board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
                if(board[0][j]==player){
                    return 10;
                } else if(board[0][j]==opponent){
                    return -10;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            if (board[0][0] == player)
                return 10;
            else if (board[0][0] == opponent)
                return -10;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            if (board[0][2] == player)
                return 10;
            else if (board[0][2] == opponent)
                return -10;
        }
        return 0;
    }

    private int minimax(int[][] board, int depth, Boolean isMax) {
        int score = evaluate(board);
        if(score == 10){
            return score;
        }
        if(score == -10){
            return score;
        }
        if(isMovesLeft(board)==false)
            return 0;

        if(isMax){
            int best = -1000;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(board[i][j] == 0){
                        board[i][j] = player;
                        best = Math.max(best,minimax(board,depth+1,!isMax));
                        board[i][j] = 0;
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == 0){
                        board[i][j] = opponent;
                        best = Math.min(best,minimax(board,depth+1,!isMax));
                        board[i][j] = 0;
                    }
                }
            }
            return best;
        }
    }
    public int findBestMove(int[][] board) {
        int bestVal = -1000;

        int row = -1;
        int col = -1;

        for(int i = 0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    board[i][j] =player;
                    int moveVal = minimax(board,0,false);
                    board[i][j]=0;
                    if(moveVal>bestVal){
                        row = i;
                        col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        int move = row * 3 + col+1;

        return move;
    }
}