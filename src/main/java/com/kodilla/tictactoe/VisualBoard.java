package com.kodilla.tictactoe;


public class VisualBoard {
    private final int sizeOfBoard;

    public VisualBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public void instruction(){


        int n = 1;
        System.out.println("It is tic toe game. Make move by entering the number as below");
        for(int i = 0; i < sizeOfBoard; i++){
            for(int j = 0; j < sizeOfBoard; j++){
                System.out.print((String.format("|%3d", n)));
                n++;
            }
            System.out.print("|\n");
        }

    }
    public void showBoard(int[][] board, int sizeOfBoard){
        String boardString = "";
        int n = 1;
        for(int i=0;i<sizeOfBoard;i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                switch(board[i][j]){
                    case 0: boardString += "|"+String.format("%3d", n); break;
                    case 1: boardString += "| O "; break;
                    case -1: boardString += "| X "; break;
                }
                n++;
            }
            boardString += "|\n";
        }
        System.out.println(boardString);
    }
}
