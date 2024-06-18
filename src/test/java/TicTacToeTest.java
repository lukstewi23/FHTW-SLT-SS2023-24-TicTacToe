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
    public void testSwitchCurrentPlayer_Positive() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testSwitchCurrentPlayer_Negative() {
        Player initialPlayer = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testGetCurrentPlayer_Positive() {
        Player player = game.getCurrentPlayer();
        assertNotNull(player);
    }

    @Test
    public void testGetCurrentPlayer_Negative() {
        Player player = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(player, game.getCurrentPlayer());
    }

    @Test
    public void testGetBoard_Positive() {
        Board board = game.getBoard();
        assertNotNull(board);
    }

    @Test
    public void testDisplayGameState_Positive() {
        String gameState = game.displayGameState();
        assertTrue(gameState.startsWith("Current player: "));
        assertTrue(gameState.contains("\n"));
    }

    @Test
    public void testDisplayGameState_Negative() {
        String gameState = game.displayGameState();
        assertFalse(gameState.isEmpty());
    }
}