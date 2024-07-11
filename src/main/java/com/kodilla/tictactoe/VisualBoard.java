package com.kodilla.tictactoe;


public class VisualBoard {
    public void instruction(){
        System.out.println("It is tic toe game. Make move by entering the number as below");
        System.out.println("|"+1+"|"+2+"|"+3+"|");
        System.out.println("|"+4+"|"+5+"|"+6+"|");
        System.out.println("|"+7+"|"+8+"|"+9+"|");
    }
    public void showBoard(int[] board){
        String boardString = "";
        for(int i=1;i<10;i++){
            switch(board[i-1]){
                case -2: boardString += "|"+i; break;
                case 1: boardString += "|O"; break;
                case 2: boardString += "|X"; break;
            }
            if(i%3==0){
                boardString += "|\n";
            }
        }
        System.out.println(boardString);
    }
}
