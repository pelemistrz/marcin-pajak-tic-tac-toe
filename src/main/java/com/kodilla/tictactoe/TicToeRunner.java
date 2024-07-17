package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicToeRunner {
    private final int sizeOfBoard;
    private final int toHowManyStrikes;
    private final int computerOrHuman;
    private final int levelOfComputer;
    Board board;
    VisualBoard visualBoard;
    GameStatus gameStatus;
    Scanner input;

    public TicToeRunner(int sizeOfBoard, int toHowManyStrikes, int computerOrHuman, int levelOfComputer) {
        this.sizeOfBoard = sizeOfBoard;
        this.toHowManyStrikes = toHowManyStrikes;
        this.computerOrHuman = computerOrHuman;
        this.levelOfComputer = levelOfComputer;
        this.board = new Board(sizeOfBoard);
        this.visualBoard = new VisualBoard(sizeOfBoard);
        this.gameStatus = new GameStatus(sizeOfBoard,toHowManyStrikes);
        this.input = new Scanner(System.in);
    }

    public void playWithColleague() {
        visualBoard.instruction();
        int move = 0;
        while(true){
            if(board.getMoveOfPlayer()==1){
                System.out.println("Move of player number 1 - O: ");
                move = input.nextInt();
                try{
                    board.checkMove(move);
                } catch (ExceptionNotAllowedMove e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                board.makeMove(move);

                if(gameStatus.checkResult(board.getBoard(),move,board.getMoveOfPlayer()) ==1){
                System.out.println("The player number 1 won\n");
                return;
                }

                board.setMoveOfPlayer(2);
            } else{
                System.out.println("Move of player number 2 - X: ");
                move = input.nextInt();
                try{
                    board.checkMove(move);
                } catch (ExceptionNotAllowedMove e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                board.makeMove(move);

                if(gameStatus.checkResult(board.getBoard(),move,board.getMoveOfPlayer()) ==-1){
                    System.out.println("The player number 2 won\n");
                    return;
                }
                board.setMoveOfPlayer(1);
            }
            visualBoard.showBoard(board.getBoard());

            if(gameStatus.isDraw(board.getHowManyMovesHasBeenMade())){
                System.out.println("It's a tie\n");
                return;
            }
        }
    }

    public void playWithComputer(){
        Computer computer = new Computer(sizeOfBoard, levelOfComputer);
        visualBoard.instruction();
        int move = 0;
        while(true){
            if(board.getMoveOfPlayer()==1){
                System.out.println("Move of player number 1 - O: ");
                move = input.nextInt();
                try{
                    board.checkMove(move);
                } catch (ExceptionNotAllowedMove e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                board.makeMove(move);
                if(gameStatus.checkResult(board.getBoard(),move,board.getMoveOfPlayer()) ==1){
                    System.out.println("The player number 1 won\n");
                    return;
                }
                board.setMoveOfPlayer(2);
            } else{
                System.out.println("Move of player number 2 - X: ");
                move = computer.computerMove(board.getBoard());
                board.makeMove(move);
                if(gameStatus.checkResult(board.getBoard(),move,board.getMoveOfPlayer()) ==-1){
                    System.out.println("The player number 2 won\n");
                    return;
                }
                board.setMoveOfPlayer(1);
            }
            visualBoard.showBoard(board.getBoard());

            if(gameStatus.isDraw(board.getHowManyMovesHasBeenMade())){
                System.out.println("It's a tie");
                return;
            }
        }
    }
}

