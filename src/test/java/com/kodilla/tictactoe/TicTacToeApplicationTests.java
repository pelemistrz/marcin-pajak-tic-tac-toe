package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TicTacToeApplicationTests {

    @Test
    void testWinRowsO() {
        //given
        Board board = new Board(10);
        GameStatus gameStatus = new GameStatus(10,5);
        //when & then
        int count = 1;
        for(int k=1; k<=95; k++) {

            for(int j=0; j<5; j++) {
                board.makeMove(k+j);
            }
            count ++;
            Assertions.assertEquals(1,gameStatus.checkResult(board.getBoard()));

            if(count == 6) {
                k=k+9;
                count = 1;
            }
            board = new Board(10);
        }

    }
}
