package com.kodilla.tictactoe;

import java.util.Scanner;

public class ApplicationTicTacToe {
    public static void main(String[] args) {
//    public void play() {
        UserManager userManager = new UserManager("Users.txt");
        Messeges messeges = new Messeges();
        boolean isGameOn = true;

        Scanner input = new Scanner(System.in);
        int sizeOfBoard = -1;
        int toHowManyStrikes = -1;
        int computerOrHuman = -1;
        int levelOfComputer = -1;

        char choice;
        do {
            if (userManager.getIdLoggedUser() == 0) {
                messeges.mainMenu();
                choice = input.nextLine().charAt(0);
                switch (choice) {
                    case '1':
                        userManager.userRegistration();
                        break;
                    case '2':
                        userManager.userLogIn();
                        break;
                    case '6':
                        isGameOn = false;
                        break;
                    default:
                        System.out.println("Invalid choice\n");
                        break;
                }
            }
            if (userManager.getIdLoggedUser() != 0) {
                messeges.ticToeOptions();
                choice = input.nextLine().charAt(0);
                switch (choice) {
                    case '1':
                        sizeOfBoard = 3;
                        toHowManyStrikes = 3;
                        computerOrHuman = 1;
                        levelOfComputer = 0;
                        break;
                    case '2':
                        sizeOfBoard = 3;
                        toHowManyStrikes = 3;
                        computerOrHuman = 2;
                        levelOfComputer = 1;
                        break;
                    case '3':
                        sizeOfBoard = 3;
                        toHowManyStrikes = 3;
                        computerOrHuman = 2;
                        levelOfComputer = 2;
                        break;
                    case '4':
                        sizeOfBoard = 10;
                        toHowManyStrikes = 5;
                        computerOrHuman = 1;
                        levelOfComputer = 0;
                        break;
                    case '5':
                        sizeOfBoard = 10;
                        toHowManyStrikes = 5;
                        computerOrHuman = 2;
                        levelOfComputer = 1;
                        break;
                    case '6':
                        isGameOn = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                if (sizeOfBoard != -1) {
                    TicToeRunner ticToeRunner = new TicToeRunner(sizeOfBoard, toHowManyStrikes, computerOrHuman, levelOfComputer);
                    if (computerOrHuman == 1) {
                        ticToeRunner.playWithColleague();
                    } else {
                        ticToeRunner.playWithComputer();
                    }
                }
            }
        } while (isGameOn);
        messeges.goodBye();
    }
}





