package com.kodilla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TicTacToeApplicationTests {
    Board board1 ;
    Board board2 ;
    Board board3 ;
    GameStatus gameStatus ;


    @BeforeEach
    void setUp() {
        Board board1 = new Board(3);
        Board board2 = new Board(3);
        Board board3 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
    }


    @Test
    void testWinRowsO() {
        //given

        //when
        board1.makeMove(1);
        board1.makeMove(2);
        board1.makeMove(3);
        board2.makeMove(4);
        board2.makeMove(5);
        board2.makeMove(6);
        board3.makeMove(7);
        board3.makeMove(8);
        board3.makeMove(9);
        //then
        assertEquals(1,gameStatus.checkResult(board1.getBoard()));
       assertEquals(1,gameStatus.checkResult(board2.getBoard()));
        assertEquals(1,gameStatus.checkResult(board3.getBoard()));
    }
    @Test
    void testWinRowsX() {
        //given
        board1.setMoveOfPlayer(2);
        board2.setMoveOfPlayer(2);
        board3.setMoveOfPlayer(2);

        //when
        board1.makeMove(1);
        board1.makeMove(2);
        board1.makeMove(3);
        board2.makeMove(4);
        board2.makeMove(5);
        board2.makeMove(6);
        board3.makeMove(7);
        board3.makeMove(8);
        board3.makeMove(9);

        //then
        assertEquals(-1,gameStatus.checkResult(board1.getBoard()));
        assertEquals(-1,gameStatus.checkResult(board2.getBoard()));
        assertEquals(-1,gameStatus.checkResult(board3.getBoard()));
    }
    @Test
    void testWinColumnO() {
        //given

        //when
        board1.makeMove(1);
        board1.makeMove(4);
        board1.makeMove(7);
        board2.makeMove(2);
        board2.makeMove(5);
        board2.makeMove(8);
        board3.makeMove(3);
        board3.makeMove(6);
        board3.makeMove(9);
        //then
        assertEquals(1,gameStatus.checkResult(board1.getBoard()));
        assertEquals(1,gameStatus.checkResult(board2.getBoard()));
        assertEquals(1,gameStatus.checkResult(board3.getBoard()));
    }
    @Test
    void testWinColumnsX() {
        //given
        board1.setMoveOfPlayer(2);
        board2.setMoveOfPlayer(2);
        board3.setMoveOfPlayer(2);

        GameStatus gameStatus = new GameStatus(3,3);
        //when & then
        board1.makeMove(1);
        board1.makeMove(4);
        board1.makeMove(7);
        board2.makeMove(2);
        board2.makeMove(5);
        board2.makeMove(8);
        board3.makeMove(3);
        board3.makeMove(6);
        board3.makeMove(9);

        assertEquals(-1,gameStatus.checkResult(board1.getBoard()));
        assertEquals(-1,gameStatus.checkResult(board2.getBoard()));
        assertEquals(-1,gameStatus.checkResult(board3.getBoard()));
    }
    @Test
    void testWinDiagonalO(){
        //given

        //when
        board1.makeMove(1);
        board1.makeMove(5);
        board1.makeMove(9);
        board2.makeMove(3);
        board2.makeMove(5);
        board2.makeMove(7);
        //then
        assertEquals(1,gameStatus.checkResult(board1.getBoard()));
        assertEquals(1,gameStatus.checkResult(board2.getBoard()));
    }
    @Test
    void testWinDiagonalX(){
        //given
        board1.setMoveOfPlayer(2);
        board2.setMoveOfPlayer(2);

        //when
        board1.makeMove(1);
        board1.makeMove(5);
        board1.makeMove(9);
        board2.makeMove(3);
        board2.makeMove(5);
        board2.makeMove(7);
        //then
        assertEquals(-1,gameStatus.checkResult(board1.getBoard()));
        assertEquals(-1,gameStatus.checkResult(board2.getBoard()));
    }
    @Test
    void testDraw(){
        //given

        //when
        board1.makeMove(1);
        board1.makeMove(3);
        board1.makeMove(4);
        board1.makeMove(6);
        board1.makeMove(8);

        board1.setMoveOfPlayer(2);
        board1.makeMove(2);
        board1.makeMove(5);
        board1.makeMove(7);
        board1.makeMove(9);

        //then
//        assertTrue(gameStatus.isDraw(board1.getBoard()));
    }
}
