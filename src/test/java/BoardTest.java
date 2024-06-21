import org.example.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace_Positive() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlace_Negative() {
        assertThrows(IllegalArgumentException.class, () -> board.place(3, 3, 'X'));
    }

    @Test
    public void testClear_Positive() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testClear_Negative() {
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testToString_Positive() {
        String boardString = board.toString();
        assertEquals(29, boardString.length());
        assertTrue(boardString.contains("|"));
        assertTrue(boardString.contains("-"));
    }

    @Test
    public void testToString_Negative() {
        String boardString = board.toString();
        assertFalse(boardString.contains("X"));
        assertFalse(boardString.contains("O"));
    }

    @Test
    public void testCheckGameStatus_Positive() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertEquals('X', board.checkGameStatus());
    }

    @Test
    public void testCheckGameStatus_Negative() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'O');
        assertNotEquals('X', board.checkGameStatus());
    }
}