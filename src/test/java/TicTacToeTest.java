import org.example.Board;
import org.example.Player;
import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testGetCurrentPlayer() {
        Player player = game.getCurrentPlayer();
        assertNotNull(player);
    }

    @Test
    public void testGetBoard() {
        Board board = game.getBoard();
        assertNotNull(board);
    }

    @Test
    public void testDisplayGameState() {
        String gameState = game.displayGameState();
        assertTrue(gameState.startsWith("Current player: "));
        assertTrue(gameState.contains("\n"));
    }

}