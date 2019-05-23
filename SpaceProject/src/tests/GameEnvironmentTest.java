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
	
//	@Test
//	public void getRandomEventTest() {
//		testGameEnvironment.getRandomEvent();
//	}


}
