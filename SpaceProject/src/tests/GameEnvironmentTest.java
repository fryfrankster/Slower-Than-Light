package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.GameEnvironment;
import main.Ship;
import main.Crew;

/**
 * Tests to check the functionality of the Game Environment class
 */
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


}
