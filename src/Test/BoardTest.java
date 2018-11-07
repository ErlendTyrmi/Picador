package Test;

import Machine.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getSquaresTest() {
        Board board = new Board();
        System.out.println(board.getSquares(23));
    }
}