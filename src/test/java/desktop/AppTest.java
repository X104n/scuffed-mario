package desktop;

import com.badlogic.gdx.physics.box2d.World;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.ScuffedMario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

	private final ScuffedMario mario = new ScuffedMario();

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
		mario.createTest();
	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testBoard() {
		World copyWorld = this.mario.getGame().getWorld();
		assertTrue(copyWorld.isLocked());
	}

	@Test
	@DisplayName("Testing if the game board is properly shown.")
	void testPlayer() {

	}

	@Test
	@DisplayName("Testing if the player can move. Has to make the player move around.")
	void testMovePlayer() {

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