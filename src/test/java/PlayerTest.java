import org.example.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player('X');
    }

    @Test
    public void testGetMarkerPositive() {
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testGetMarkerNegative() {
        assertNotEquals('O', player.getMarker());
    }
}