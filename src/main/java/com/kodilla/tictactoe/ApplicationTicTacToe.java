package com.kodilla.tictactoe;

import java.util.Scanner;

public class ApplicationTicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeOfBoard = -1;
        int toHowManyStrikes = -1;
        int computerOrHuman = -1;
        int levelOfComputer = -1;
        int whichGame = -1;
        int choice = -1;

        while (true) {
            System.out.println("Welcome in TicTacToe game.\nPlease choose size of board: \n1. 3x3\n2. 10x10\n");
            whichGame = input.nextInt();
            switch (whichGame) {
                case 1:
                    System.out.println("Do you want play with colleague (press 1) or computer (press 2 for normal level, press 3 for hard mode:)):");
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
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Do you want play with colleague (press 1) or dumb computer (press 2 (I haven't make hard mode for 10x10)");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            sizeOfBoard = 10;
                            toHowManyStrikes = 5;
                            computerOrHuman = 1;
                            levelOfComputer = 0;
                            break;
                        case 2:
                            sizeOfBoard = 10;
                            toHowManyStrikes = 5;
                            computerOrHuman = 2;
                            levelOfComputer = 1;
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2");
                    break;
            }
            TicToeRunner ticToeRunner = new TicToeRunner(sizeOfBoard,toHowManyStrikes,computerOrHuman,levelOfComputer);
            if(computerOrHuman ==1){
                ticToeRunner.playWithColleague();
            } else {
                ticToeRunner.playWithComputer();
            }
        }
    }
}





