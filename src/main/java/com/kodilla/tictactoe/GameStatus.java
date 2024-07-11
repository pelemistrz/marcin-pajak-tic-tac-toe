package com.kodilla.tictactoe;

public class GameStatus {
    private final int sizeOfBoard;
    private final int toHowManyStrikes;

    public GameStatus(int sizeOfBoard,int toHowManyStrikes) {
        this.sizeOfBoard = sizeOfBoard;
        this.toHowManyStrikes = toHowManyStrikes;
    }


    public int checkResult(int[][] tempBoard) {
        int count = 0;
        int winO = toHowManyStrikes;
        int winX = -toHowManyStrikes;


        for(int i = 0; i < sizeOfBoard; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i][j+k];
                 }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j < sizeOfBoard; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i+k][j];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = 0; k < toHowManyStrikes; k++) {
                    count += tempBoard[i+k][j+k];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }
        for(int i = 0; i <= sizeOfBoard-toHowManyStrikes; i++) {
            for(int j = 0; j <= sizeOfBoard-toHowManyStrikes; j++) {
                for(int k = toHowManyStrikes-1; k >=0; k--) {
                    count += tempBoard[i+k][j+k];
                }
                if(count == winO) {
                    return 1;
                }
                if(count == winX) {
                    return -1;
                }
                count = 0;
            }
        }

        return 0;


    }
}
//        int number;
//        for (int check = 0; check < 8; check++) {
//            number = 0;
//            switch (check){
//                case 0:
//                    number += tempBoard[0] + tempBoard[1] + tempBoard[2];
//                    break;
//                case 1:
//                    number += tempBoard[3] + tempBoard[4] + tempBoard[5];
//                    break;
//                case 2:
//                    number += tempBoard[6] + tempBoard[7] + tempBoard[8];
//                    break;
//                case 3:
//                    number += tempBoard[0] + tempBoard[4] + tempBoard[8];
//                    break;
//                case 4:
//                    number += tempBoard[1] + tempBoard[4] + tempBoard[7];
//                    break;
//                case 5:
//                    number += tempBoard[2] + tempBoard[5] + tempBoard[8];
//                    break;
//                case 6:
//                    number += tempBoard[0] + tempBoard[4] + tempBoard[8];
//                    break;
//                case 7:
//                    number += tempBoard[2] + tempBoard[4] + tempBoard[6];
//                    break;
//            }
//            if (number == 3) return 1;
//            if (number == 6) return 2;
//        }
//        return 0;
//    }
//    public boolean isDraw(int[] board) {
//        boolean isDraw = true;
//        for(int i = 0; i < 9; i++){
//            if(board[i] == -2) isDraw = false;
//        }
//        return isDraw;
//    }
//}
