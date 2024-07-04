package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicToeRunner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        VisualBoard visualBoard = new VisualBoard();

        visualBoard.instruction();

        int numberOfMoves = 0;
        while(numberOfMoves<9){
            System.out.println("Player number 1 - O");

            System.out.println("Player number 2 - X");


            if(GameStatus.checkWinner(board) ==1){
                System.out.println("Wygrał gracz 1");
                return;
            }
            if(GameStatus.checkWinner(board) ==2){
                System.out.printf("Wygral gracz 2");
                return;
            }
            numberOfMoves++;
        }
        System.out.println("It's a tie");
    }
}


//
//        int numberOfMoves = 0;
//        GameData gameData = new GameData();
//        EntryHandling entryHandling = new EntryHandling();
//        while(/*entryHandling.checkWinner() ||*/ numberOfMoves<9 ){
//            entryHandling.showBoard();
//            entryHandling.makeMoveNo1();
//            entryHandling.showBoard();
//            entryHandling.makeMoveNo2();
//            numberOfMoves++;
