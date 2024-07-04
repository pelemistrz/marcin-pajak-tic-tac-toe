package com.kodilla.tictactoe;

import java.util.Scanner;

public class Board {
    int[][] board = new int[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = -2;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}


//
//    public void makeMoveNo1(){
//       int move = -1;
//        instruction();
//        move = input.nextInt();
//        board[move-1] = "O";
//    }
//    public void makeMoveNo2(){
//        int move = -1;
//        instruction();
//        move = input.nextInt();
//        board[move-1] = "X";
//    }
//    boolean checkWinner(){
//        return true;
//    }
//}
