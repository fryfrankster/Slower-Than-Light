package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Chungus;
import main.Engineer;
import main.Planet;
import main.RandomEvent;
import main.Scavenger;
import main.Ship;
import main.Robot;
import main.Soldier;
import main.Worker;

class CrewMemberTest {
	private Chungus testChungus;
	private Engineer testEngineer;
	private Scavenger testScavenger;
	private Robot testRobot;
	private Worker testWorker;
	private Soldier testSoldier;
	private Ship testShip;
	private Planet testPlanet;
	private RandomEvent testRandomEvent;
	
	@BeforeEach
	public void init() {
		testChungus = new Chungus("Chungus");
		testEngineer = new Engineer("Engineer");
		testScavenger = new Scavenger("Scavenger");
		testRobot = new Robot("Robot");
		testWorker = new Worker("Worker");
		testSoldier = new Soldier("Soldier");
		
		testShip = new Ship("Ship");
		testPlanet = new Planet();
		testRandomEvent = new RandomEvent();
 	}

	@Test
	public void isPlagueImmuneTest() {
		assertTrue(testRobot.isPlaugeImmune());
		//Check that other types are not plague immune
	}
	
	@Test
	public void canPerformActionTest() {
		//Initial actions performed set to 0
		assertTrue(testChungus.canPerformAction());
		
		//One available action left, performed one action
		testChungus.setActionsCompleted(1);
		assertTrue(testChungus.canPerformAction());
		
		//No more available actions left
		testChungus.setActionsCompleted(2);
		assertEquals(testChungus.getActionsCompleted(), testChungus.getActionsPerDay());
		assertFalse(testChungus.canPerformAction());
	}
	
	
	
	@Test
	public void sleepTest(){
		//When a crew member has maximum tiredness, sleep is not performed
		assertTrue(testChungus.getTiredness() == testChungus.getMaxTiredness());
		assertEquals(testChungus.getName() + " is not tired!", testChungus.sleep());
		assertTrue(testChungus.getActionsCompleted() == 0);
		
		//When crew member tiredness is not at maximum tiredness, sleep is performed
		testChungus.increaseTiredness();
		assertNotEquals(testChungus.getMaxTiredness(), testChungus.getTiredness());
		assertEquals(testChungus.getName() + " has slept", testChungus.sleep());
		assertTrue(testChungus.getActionsCompleted() > 0);
		
	}
	
	@Test
	public void repairShieldsTest() {
		//When a shield is at maximum, repair shields is not performed
		assertEquals(testShip.getMaxShieldLevel(), testShip.getCurrentShieldLevel());
		assertEquals("The shields are already at full health!", testEngineer.repairShields(testShip));
		assertTrue(testChungus.getActionsCompleted() == 0);
		
		//When a shield is not at maximum, repair shields is performed
		testShip.decreaseShieldLevel(-1);
		assertNotEquals(testShip.getMaxShieldLevel(), testShip.getCurrentShieldLevel());
		assertEquals(testEngineer.getName() + " has repaired the ships shields", testEngineer.repairShields(testShip));
		
	}
	
	
	
	@Test 
	public void pilotShipTest() {
		//Check the outpost items to compare difference, checks if moved to a new planet
		testEngineer.pilotShip(testChungus, testPlanet, testRandomEvent, testShip);

	}
	
	
	

}
