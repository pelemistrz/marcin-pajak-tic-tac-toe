package com.kodilla.tictactoe;

public class GameStatus {
    private final int sizeOfBoard;
    private final int toHowManyStrikes;

    public GameStatus(int sizeOfBoard,int toHowManyStrikes) {
        this.sizeOfBoard = sizeOfBoard;
        this.toHowManyStrikes = toHowManyStrikes;
    }

    public int checkResult(int[][] tempBoard, int move , int whoseMove){
        int row = (int) (move-1)/sizeOfBoard;
        int col =  (move-1)%sizeOfBoard;
        int XorO = 0;
        if(whoseMove == 1){
            XorO = 1;
        } else if(whoseMove == 2){
            XorO = -1;
        }

        int count = 0;
        //check rows
        for(int i = 1; i< toHowManyStrikes && row+i<sizeOfBoard-1; i++){
            if(tempBoard[row+i][col] == XorO){
                count++;
            } else{
                break;
            }
        }
        for(int i = 1; i< toHowManyStrikes && row-i>=0; i++){
            if(tempBoard[row-i][col] == XorO){
                count++;
            } else{
                break;
            }
        }
        if(count == toHowManyStrikes-1){
            return XorO;
        }
        count = 0;
        //check column
        for(int i = 1; i< toHowManyStrikes && col+i<sizeOfBoard-1; i++){
            if(tempBoard[row][col+i] == XorO){
                count++;
            } else{
                break;
            }
        }
        for(int i = 1; i< toHowManyStrikes && col-i>=0; i++){
            if(tempBoard[row][col-i] == XorO){
                count++;
            } else{
                break;
            }
        }
        if(count == toHowManyStrikes-1){
            return XorO;
        }
        count = 0;
        //check antidiagonal
        for(int i = 1; i< toHowManyStrikes && col+i<sizeOfBoard-1 && row+i<sizeOfBoard-1; i++){
            if(tempBoard[row+i][col+i] == XorO){
                count++;
            } else{
                break;
            }
        }
        for(int i = 1; i< toHowManyStrikes && col-i>=0 && row-i>=0; i++){
            if(tempBoard[row-i][col-i] == XorO){
                count++;
            } else{
                break;
            }
        }
        if(count == toHowManyStrikes-1){
            return XorO;
        }
        //check 1 diagonal
        count=0;

        for(int i = 1; i< toHowManyStrikes && col-i>=0 && row+i<sizeOfBoard-1; i++){
            if(tempBoard[row+i][col-i] == XorO){
                count++;
            } else{
                break;
            }
        }
        for(int i = 1; i< toHowManyStrikes && col+i<sizeOfBoard-1 && row-i>=0; i++){
            if(tempBoard[row-i][col+i] == XorO){
                count++;
            } else{
                break;
            }
        }
        if(count == toHowManyStrikes-1){
            return XorO;
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
