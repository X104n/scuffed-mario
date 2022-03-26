package desktop;

import static org.junit.jupiter.api.Assertions.*;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.ScuffedMario;

public class AppTest {

	static ScuffedMario mario = new ScuffedMario();

	/**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Glory to Ukraine");
		config.setWindowIcon("assets/Images/Icon.png");
		config.setWindowSizeLimits(800, 480, 9999, 9999);
		new Lwjgl3Application(mario, config);
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
		assertTrue(mario.getGame().getTiledMapHandler().isCreated());
	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testPlayer() {
		assertTrue(mario.getGame().getTiledMapHandler().isCreatePlayer());
	}

	@Test
	@DisplayName("Testing if the player can move. Has to make the player move around.")
	void testMovePlayer() {
		assertTrue(mario.getGame().getPlayer().isMoved());
	}

	@Test
	@DisplayName("Testing if the player won't go through the blocks/terrain.")
	//This test may be impossible to find out as the classes used provide items that do not collide
		// with each other,nor have their positions saved in any types of lists.
	void testInteractWithTerrain(){
	}

	@Test
	void testPoints(){

	}

	@Test
	void testEnemies(){

	}

	@Test
	void testDeath(){

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