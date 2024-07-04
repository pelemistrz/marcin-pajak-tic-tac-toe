package com.kodilla.tictactoe;


public class VisualBoard {
    public void instruction(){
        System.out.println("It is tic toe game. Make move by entering the number as below");
        System.out.println("|"+1+"|"+2+"|"+3+"|");
        System.out.println("|"+4+"|"+5+"|"+6+"|");
        System.out.println("|"+7+"|"+8+"|"+9+"|");
    }
    public void showBoard(Board board){
        String boardString = "";
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                switch(board.getBoard()[i][j]){
                    case -2: boardString += "| "; break;
                    case 1: boardString += "|O"; break;
                    case 2: boardString += "|X"; break;
                }
            }
            boardString += "|\n";
        }
        System.out.println(boardString);
    }
}
