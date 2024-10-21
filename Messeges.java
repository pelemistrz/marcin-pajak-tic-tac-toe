package com.kodilla.tictactoe;

public class Messeges {
    public void mainMenu(){
        System.out.println("      >>>> MAIN MENU   <<<<");
        System.out.println("---------------------------");
        System.out.println("1. Sign in");
        System.out.println("2. Log in");
        System.out.println("7. Exit");
        System.out.println("---------------------------");
        System.out.println("Enter your choice: ");
    }
    public void ticToeOptions(){
        System.out.println("Welcome in TicTacToe game.");
        System.out.println("---------------------------");
        System.out.println("Please choose size of board and way of playing: \n1. 3x3 with colleague");
        System.out.println("2. 3x3 with computer - level easy\n3. 3x3 with computer - level hard\n4. 10x10 with colleague");
        System.out.println("5. 10x10 with computer");
        System.out.println("6. Show my statistics");
        System.out.println("7. Exit game");
        System.out.println("Enter your choice: ");
    }
    public void goodBye(){
        System.out.println("\nGoodbye! Thank you for playing!");
    }
}
