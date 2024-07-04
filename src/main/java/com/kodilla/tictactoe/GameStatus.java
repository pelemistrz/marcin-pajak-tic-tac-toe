package com.kodilla.tictactoe;

public class GameStatus {
    public int checkWinner(Board board) {
        int[] tempBoard = board.getBoard();
        int number;
        for (int check = 0; check < 8; check++) {
            number = 0;
            switch (check){
                case 0:
                    number += tempBoard[0] + tempBoard[1] + tempBoard[2];
                    break;
                case 1:
                    number += tempBoard[3] + tempBoard[4] + tempBoard[5];
                    break;
                case 2:
                    number += tempBoard[6] + tempBoard[7] + tempBoard[8];
                    break;
                case 3:
                    number += tempBoard[0] + tempBoard[4] + tempBoard[8];
                    break;
                case 4:
                    number += tempBoard[1] + tempBoard[4] + tempBoard[7];
                    break;
                case 5:
                    number += tempBoard[2] + tempBoard[5] + tempBoard[8];
                    break;
                case 6:
                    number += tempBoard[0] + tempBoard[4] + tempBoard[8];
                    break;
                case 7:
                    number += tempBoard[2] + tempBoard[4] + tempBoard[6];
                    break;
            }
            if (number == 3) return 1;
            if (number == 6) return 2;
        }
        return 0;
    }
    public boolean isDraw(Board board) {
        boolean isDraw = true;
        for(int i = 0; i < 9; i++){
            if(board.getBoard()[i] == -2) isDraw = false;
        }
        return isDraw;
    }
}
