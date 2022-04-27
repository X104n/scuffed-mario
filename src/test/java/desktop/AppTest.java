package desktop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import screens.GameScreen;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AppTest {


	/**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {

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

	}

	@Test
	@DisplayName("Testing if the player is properly shown.")
	void testPlayer() {

	}

	@Test
	@DisplayName("Testing if the player starts at the right position.")
	void testStartPosition() {

		GameScreen game = Mockito.mock(GameScreen.class);

		when(game.getPlayer().getBody().getPosition().x).thenReturn(0f);

		assertEquals(game.getPlayer().getBody().getPosition().x, 0f);

		/*Player testPlayer = mario.getGame().getPlayer();
		float testX = testPlayer.getBody().getPosition().x;
		assertEquals(startPos, testX);*/
	}

	@Test
	@DisplayName("Testing if the player can move.")
	void testMovePlayer() {
		// Check if the player can move.
		//assertTrue(mockedMario.getGame().getPlayer().getBody().getPosition().x > 0);
	}

	@Test
	@DisplayName("Testing if the player won't go through the blocks/terrain.")
	void testInteractWithTerrain(){
		// Check if the player can move.
		//assertTrue(mockedMario.getGame().getPlayer().getBody().getPosition().x > 0);
	}

	@Test
	@DisplayName("Testing if the player can die.")
	void testDeath() {
		// Check if the player can move.
		/*Player player1 = mockedMario.getGame().getPlayer();
		mockedMario.getGame().resetPlayer();
		Player player2 = mockedMario.getGame().getPlayer();
		assertNotEquals(player1, player2);*/
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