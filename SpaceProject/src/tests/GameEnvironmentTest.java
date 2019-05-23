package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.GameEnvironment;
import main.Ship;
import main.Crew;

class GameEnvironmentTest {
	private GameEnvironment testGameEnvironment;
	private Ship testShip;
	private Crew testCrew;
	
	@Test
	public void init() {
		testGameEnvironment = new GameEnvironment();
		testShip = new Ship("Ship");
		testCrew = new Crew("Crew");
	}
	
	@Test
	public void setupGameTest() {
		testGameEnvironment.setupGame("Ship", "Crew", 10);
		assertEquals("Ship", testGameEnvironment.getShip().getName());
		assertEquals("Crew", testGameEnvironment.getCrew().getName());
		assertEquals(1, testGameEnvironment.getCurrentDay());
		assertEquals(10, testGameEnvironment.getGameLength());
	}

}
