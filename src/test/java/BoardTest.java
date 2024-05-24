import org.example.Board;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmptyPositive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmptyNegative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlacePositive() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPlaceNegative() {
        board.place(3, 3, 'X');
    }

    @Test
    public void testIsFullPositive() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFullNegative() {
        assertFalse(board.isFull());
    }

    @Test
    public void testClearPositive() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test(expected = AssertionError.class)
    public void testClearNegative() {
        board.clear();
        assertFalse(board.isCellEmpty(0, 0));
    }
}