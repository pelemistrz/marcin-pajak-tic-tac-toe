package com.kodilla.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;


class TicTacToeApplicationTests {
    Board board1 ;
    GameStatus gameStatus ;

    @Test
    void testNotAllowedMoves(){
       //give
        Board board1 = new Board(3);
        board1.makeMove(2);
        //when & then
        assertAll(
                () -> assertThrows(ExceptionNotAllowedMove.class,()->board1.checkMove(10)),
                () -> assertThrows(ExceptionNotAllowedMove.class,()->board1.checkMove(2)),
                () -> assertDoesNotThrow(()->board1.checkMove(4))
        );
    }

    @Test
    void testWinRowsO() {
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
        //when
        board1.makeMove(6);
        board1.makeMove(5);

        //then
       assertEquals(1,gameStatus.checkResult(board1.getBoard(),4,1));
    }

    @Test
    void testNotWinYetO(){
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
        //when
        board1.makeMove(1);
        //then
        assertEquals(0,gameStatus.checkResult(board1.getBoard(),3,1));
    }

    @Test
    void testWinRowsX() {
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
        board1.setMoveOfPlayer(2);

        //when
        board1.makeMove(4);
        board1.makeMove(5);


        //then
        assertEquals(-1,gameStatus.checkResult(board1.getBoard(),6,2));
    }

    @Test
    void testWinColumnO() {
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);

        //when
        board1.makeMove(1);
        board1.makeMove(4);

        //then
        assertEquals(1,gameStatus.checkResult(board1.getBoard(),7,1));
    }

    @Test
    void testWinColumnsX() {
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
        board1.setMoveOfPlayer(2);

        //when & then
        board1.makeMove(1);
        board1.makeMove(4);

        assertEquals(-1,gameStatus.checkResult(board1.getBoard(),7,2));
    }
    @Test
    void testWinDiagonalO(){
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);

        //when
        board1.makeMove(1);
        board1.makeMove(5);

        //then
        assertEquals(1,gameStatus.checkResult(board1.getBoard(),9,1));

    }
    @Test
    void testWinDiagonalX(){
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);
        board1.setMoveOfPlayer(2);

        //when
        board1.makeMove(7);
        board1.makeMove(5);

        //then
        assertEquals(-1,gameStatus.checkResult(board1.getBoard(),3,2));

    }
    @Test
    void testDraw(){
        //given
        Board board1 = new Board(3);
        GameStatus gameStatus = new GameStatus(3,3);

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
        assertTrue(gameStatus.isDraw(board1.getHowManyMovesHasBeenMade()));
    }
}
