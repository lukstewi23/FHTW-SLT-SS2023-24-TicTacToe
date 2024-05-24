import org.example.TicTacToe;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testStartPositive() {
        game.start();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    @Test
    public void testHasWinnerPositive() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerNegative() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'O');
        game.getBoard().place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }
}