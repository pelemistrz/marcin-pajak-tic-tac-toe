package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicToeRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        VisualBoard visualBoard = new VisualBoard();
        GameStatus gameStatus = new GameStatus();
        visualBoard.instruction();

        int move = 0;
        while(true){
            if(board.getMoveOfPlayer()==1){
                System.out.println("Move of player number 1 - O: ");
                move = input.nextInt();
                board.changeBoard(move);
                board.setMoveOfPlayer(2);
            } else{
                System.out.println("Move of player number 2 - X: ");
                move = input.nextInt();
                board.changeBoard(move);
                board.setMoveOfPlayer(1);
            }
            visualBoard.showBoard(board);


            if(gameStatus.checkWinner(board) ==1){
                System.out.println("The player number 1 won");
                return;
            }
            if(gameStatus.checkWinner(board) ==2){
                System.out.printf("The player nomber 2 won");
                return;
            }
            if(gameStatus.checkWinner(board) ==3){
                System.out.println("It's a tie");
                return;
            }
            if(gameStatus.isDraw(board)){
                System.out.println("It's a tie");
                return;
            }
        }
    }
}



