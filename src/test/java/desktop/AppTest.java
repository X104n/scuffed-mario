package desktop;

import Objects.Entity;
import Objects.Player;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.GameScreen;
import screens.MainMenu;
import screens.ScuffedMario;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {

	static GameScreen game;
	static Player mockPlayer;
	static ScuffedMario mario;

	@BeforeAll
	static void setUpBeforeAll() {
		game = mock(GameScreen.class);
		mockPlayer = mock(Player.class);
		mario = mock(ScuffedMario.class);
	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testBoard() {
		World randomWorld = new World(new Vector2(0, -25f), false);

		when(game.getWorld()).thenReturn(randomWorld);
		assertEquals(randomWorld, game.getWorld());
	}

	@Test
	@DisplayName("Testing if the player is properly shown.")
	void testPlayer() {
		when(game.getPlayer()).thenReturn(mockPlayer);
		assertEquals(mockPlayer, game.getPlayer());
	}

	@Test
	@DisplayName("Testing if the player starts at the right position.")
	void testStartPosition() {
		when(mockPlayer.getPosition()).thenReturn(0.0);
		double position = mockPlayer.getPosition();
		when(mockPlayer.movePosition("D", position)).thenReturn(-0.1);

		assertEquals(-0.1, mockPlayer.movePosition("D", position));
	}

	@Test
	@DisplayName("Testing if the player can move.")
	void testMovePlayer() {
		when(mockPlayer.getPosition()).thenReturn(0.0);
	}

	@Test
	@DisplayName("Testing if the player can die.")
	void testDeath() {
		when(mockPlayer.playerDead()).thenReturn(true);

		assertTrue(mockPlayer.playerDead());
	}

	@Test
	void testEnemies(){
		ArrayList<Entity> mockEnemies = mock(ArrayList.class);

		when(game.getEnemies()).thenReturn(mockEnemies);
		assertEquals(mockEnemies, game.getEnemies());
	}

	@Test
	void testStartScreen(){
		MainMenu randomMenu = mock(MainMenu.class);

		when(mario.getMenu()).thenReturn(randomMenu);
		assertEquals(randomMenu, mario.getMenu());
	}
}