package com.kodilla.tictactoe;

import java.util.Scanner;

import static java.lang.System.exit;

public class ApplicationTicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeOfBoard = -1;
        int toHowManyStrikes = -1;
        int computerOrHuman = -1;
        int levelOfComputer = -1;
        int choice = -1;

        while (true) {
            System.out.println("Welcome in TicTacToe game.\nPlease choose size of board and way of playing: \n1. 3x3 with colleague");
            System.out.println("2. 3x3 with computer - level easy\n3. 3x3 with computer - level hard\n4. 10x10 with colleague");
            System.out.println("5. 10x10 with computer");
            System.out.println("6. Exit game");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    sizeOfBoard = 3;
                    toHowManyStrikes = 3;
                    computerOrHuman = 1;
                    levelOfComputer = 0;
                    break;
                case 2:
                    sizeOfBoard = 3;
                    toHowManyStrikes = 3;
                    computerOrHuman = 2;
                    levelOfComputer = 1;
                break;
                case 3:
                    sizeOfBoard = 3;
                    toHowManyStrikes = 3;
                    computerOrHuman = 2;
                    levelOfComputer = 2;
                    break;
                case 4:
                    sizeOfBoard = 10;
                    toHowManyStrikes = 5;
                    computerOrHuman = 1;
                    levelOfComputer = 0;
                    break;
                case 5:
                    sizeOfBoard = 10;
                    toHowManyStrikes = 5;
                    computerOrHuman = 2;
                    levelOfComputer = 1;
                    break;
                case 6:
                    exit(0);
                break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if(sizeOfBoard ==-1){
                continue;
            } else {
                TicToeRunner ticToeRunner = new TicToeRunner(sizeOfBoard,toHowManyStrikes,computerOrHuman,levelOfComputer);
                if(computerOrHuman ==1){
                    ticToeRunner.playWithColleague();
                } else {
                    ticToeRunner.playWithComputer();
                }
            }
        }
   }
}





