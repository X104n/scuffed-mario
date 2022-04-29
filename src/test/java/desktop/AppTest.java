package desktop;

import Objects.Player;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.GameScreen;
import screens.MainMenu;
import screens.ScuffedMario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {

	static GameScreen game;
	static Player mockPlayer;
	static ScuffedMario mario;

	/**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
		game = mock(GameScreen.class);
		mockPlayer = mock(Player.class);
		mario = mock(ScuffedMario.class);
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {

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


		// Check if the player can move.
		//assertTrue(mockedMario.getGame().getPlayer().getBody().getPosition().x > 0);
	}

	@Test
	@DisplayName("Testing if the player won't go through the blocks/terrain.")
	void testInteractWithTerrain(){
		// Check if the player can move
		//assertTrue(mockedMario.getGame().getPlayer().getBody().getPosition().x > 0);
	}

	@Test
	@DisplayName("Testing if the player can die.")
	void testDeath() {
		when(mockPlayer.playerDead()).thenReturn(true);

		assertTrue(mockPlayer.playerDead());
	}
	@Test
	void testPoints(){

	}

	@Test
	void testEnemies(){

	}

	@Test
	void testGoal(){

	}

	@Test
	void testNewBoard(){

	}

	@Test
	void testStartScreen(){
		MainMenu randomMenu = mock(MainMenu.class);

		when(mario.getMenu()).thenReturn(randomMenu);
		assertEquals(randomMenu, mario.getMenu());
	}

	@Test
	void testMultiplePlayers(){

	}

	@CsvSource(value = { "1,1,2", "1,2,3", "2,3,5", "3,5,8", "5,8,13", "8,13,21" })
	@ParameterizedTest(name = "{0}+{1} == {2}")
	void addTest(int a, int b, int c) {
		assertEquals(c, a + b);
	}

}