package com.kodilla.tictactoe;

public class GameStatus {
    public static int checkWinner(Board board) {
        int[][] tempBoard = board.getBoard();
        int number;
        for (int check = 0; check < 8; check++) {
            number = 0;
            switch (check){
                case 0:
                    number += tempBoard[0][0] + tempBoard[0][1] + tempBoard[0][2];
                    break;
                case 1:
                    number += tempBoard[1][0] + tempBoard[1][1] + tempBoard[1][2];
                    break;
                case 2:
                    number += tempBoard[2][0] + tempBoard[2][1] + tempBoard[2][2];
                    break;
                case 3:
                    number += tempBoard[0][0] + tempBoard[1][0] + tempBoard[2][0];
                    break;
                case 4:
                    number += tempBoard[0][1] + tempBoard[1][1] + tempBoard[2][1];
                    break;
                case 5:
                    number += tempBoard[0][2] + tempBoard[1][2] + tempBoard[2][2];
                    break;
                case 6:
                    number += tempBoard[0][0] + tempBoard[1][1] + tempBoard[2][2];
                    break;
                case 7:
                    number += tempBoard[0][2] + tempBoard[1][1] + tempBoard[2][2];
                    break;
            }
            if (number == 3) return 1;
            if (number == 6) return 2;
        }
        return -1;
    }
}
