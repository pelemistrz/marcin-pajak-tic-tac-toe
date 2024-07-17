package com.kodilla.tictactoe;

public class GameStatus {
    private final int sizeOfBoard;
    private final int toHowManyStrikes;

    public GameStatus(int sizeOfBoard,int toHowManyStrikes) {
        this.sizeOfBoard = sizeOfBoard;
        this.toHowManyStrikes = toHowManyStrikes;
    }

    public int checkResult(int[][] tempBoard) {
        int count = 0;
        int winO = toHowManyStrikes;
        int winX = -toHowManyStrikes;

        for(int i = 0; i < sizeOfBoard; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i][j+k];
                 }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j < sizeOfBoard; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i+k][j];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i+k][j+k];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = toHowManyStrikes-1; k >=0; k--) {
                    count += tempBoard[i+toHowManyStrikes-1-k][j+k];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        return 0;
    }

    public boolean isDraw(int howManyMovesHasBeenMade) {
        boolean isDraw = false;
        int maksNumbersOfMoves = sizeOfBoard*sizeOfBoard;
        if(maksNumbersOfMoves == howManyMovesHasBeenMade) {
            isDraw = true;
        }
        return isDraw;
    }
}
