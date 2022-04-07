package desktop;

import Objects.Player;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.GameScreen;
import screens.ScuffedMario;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

	public static ScuffedMario mario = new ScuffedMario();
	float startPos;

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
		//In case a test requires booleans.
		boolean confirm = false;
		startPos = mario.getGame().getPlayer().getBody().getPosition().x;
	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testBoard() {

	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testPlayer() {

	}

	@Test
	@DisplayName("Testing if the player starts at the right position.")
	void testStartPosition() {
		Player testPlayer = mario.getGame().getPlayer();
		float testX = testPlayer.getBody().getPosition().x;
		assertEquals(startPos, testX);
	}

	@Test
	@DisplayName("Testing if the player can move.")
	void testMovePlayer() {

	}

	@Test
	@DisplayName("Testing if the player won't go through the blocks/terrain.")
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