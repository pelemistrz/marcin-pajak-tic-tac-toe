package com.kodilla.tictactoe;


import java.util.Random;

public class Computer {
    private final int sizeOfBoard;
    private final int levelOfComputer;

    public Computer(int sizeOfBoard, int levelOfComputer) {
        this.sizeOfBoard = sizeOfBoard;
        this.levelOfComputer = levelOfComputer;
    }

    public int computerMove(int[][] board) {
        Random rand = new Random();
        int move;
        int row;
        int col;
        do {
            move = rand.nextInt(sizeOfBoard * sizeOfBoard - 1) + 1;
            row = (int) (move - 1) / sizeOfBoard;
            col = (move - 1) % sizeOfBoard;
        }
        while (board[row][col] != 0);
        return move;
    }

//    public int findBestMove(int[][] board) {
//        int bestMove = null;
//        for()
//            if(currentMove>bestMove){
//                bestMove = currentMove;
//            }
//
//        return bestMove;
//
//    }


//    static Move findBestMove() {
//        int bestVal = Integer.MIN_VALUE;
//        Move bestMove = new Move();
//        bestMove.row = -1;
//        bestMove.column = -1;
//        /*
//        for each child of this this state
//        evaluate the outcome of going in this pass
//        then get the best one of them
//        */
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                // Check if cell is empty
//                if (board[i][j] == ' ') {
//                    // Make the move
//                    board[i][j] = AI;
//                    // compute evaluation function for this move
//                    int moveVal = minimax(100, false);
//
//                    // Undo after modifing the original board
//                    board[i][j] = ' ';
//                    if (moveVal > bestVal) {
//                        bestMove.row = i;
//                        bestMove.column = j;
//                        bestVal = moveVal;
//                    }
//                }
//            }
//        }
//        return bestMove;
//    }
//
//    public static int minimax(int depth, boolean isMaximizing) {
//        int gameState = checkGameState();
//        if (gameState != NOT_FINISHED_STATE || depth == 0) {
//            return gameState;
//        }
//
//        if (isMaximizing) {
//            int bestScore = Integer.MIN_VALUE;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    // Is the cell available?
//                    if (board[i][j] == ' ') {
//                        board[i][j] = AI;
//                        int score = minimax(depth - 1, false);
//                        board[i][j] = ' ';
//                        bestScore = Integer.max(score, bestScore);
//                    }
//                }
//            }
//
//            return bestScore;
//        } else {
//            int bestScore = Integer.MAX_VALUE;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    // Is the cell available?
//                    if (board[i][j] == ' ') {
//                        board[i][j] = HUMAN;
//                        int score = minimax(depth - 1, true);
//                        board[i][j] = ' ';
//                        bestScore = Integer.min(score, bestScore);
//                    }
//                }
//            }
//            return bestScore;
//        }


}