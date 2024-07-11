package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicToeRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please insert size of board");
        int sizeOfBoard = input.nextInt();
        System.out.println("Please insert how many strikes do you want play");
        int toHowManyStrikes = input.nextInt();

        Board board = new Board(sizeOfBoard);
        VisualBoard visualBoard = new VisualBoard(sizeOfBoard);
        GameStatus gameStatus = new GameStatus(sizeOfBoard,toHowManyStrikes);

        visualBoard.instruction();
        int move = 0;
        while(true){
            if(board.getMoveOfPlayer()==1){
                System.out.println("Move of player number 1 - O: ");
                move = input.nextInt();
                if(board.checkMove(move)){
                    System.out.println("Please enter move which is in range and not taken");
                    continue;
                }
                board.changeBoard(move);
                board.setMoveOfPlayer(2);
            } else{
                System.out.println("Move of player number 2 - X: ");
                move = input.nextInt();
                if(board.checkMove(move)){
                    System.out.println("Please enter move which is in range and not taken");
                    continue;
                }
                board.changeBoard(move);
                board.setMoveOfPlayer(1);
            }
            visualBoard.showBoard(board.getBoard(),sizeOfBoard);

            if(gameStatus.checkResult(board.getBoard()) ==1){
                System.out.println("The player number 1 won");
                return;
            }
            if(gameStatus.checkResult(board.getBoard()) ==-1){
                System.out.printf("The player nomber 2 won");
                return;
            }
            if(gameStatus.isDraw(board.getBoard())){
                System.out.println("It's a tie");
                return;
            }
        }
    }
}



