package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicToeRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please insert size of board");
        int sizeOfBoard = input.nextInt();



        Board board = new Board(sizeOfBoard);
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
            visualBoard.showBoard(board.getBoard());

            if(gameStatus.checkWinner(board.getBoard()) ==1){
                System.out.println("The player number 1 won");
                return;
            }
            if(gameStatus.checkWinner(board.getBoard()) ==2){
                System.out.printf("The player nomber 2 won");
                return;
            }
//            if(gameStatus.isDraw(board.getBoard())){
//                System.out.println("It's a tie");
//                return;
//            }
        }
    }
}



