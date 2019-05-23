package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Chungus;
import main.Engineer;
import main.FoodItem;
import main.MedicalItem;
import main.Planet;
import main.RandomEvent;
import main.Scavenger;
import main.Ship;
import main.Robot;
import main.Soldier;
import main.Worker;
import main.Crew;

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
	private Crew testCrew;
	
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
		testCrew = new Crew("Crew Name");
		
		testCrew.addItem(new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>"));
		testCrew.addItem(new MedicalItem("Alien antibiotics", 75, 25, "Cures space plague and restores health ", true));
		testCrew.addItem(new MedicalItem("Band Aid", 25, 10, "Restores a small amount of health", false));

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
		
		//If tired
		testChungus.increaseTiredness();
		testChungus.increaseTiredness();
		testChungus.increaseTiredness();
		testChungus.increaseTiredness();
		testChungus.increaseTiredness();
		assertTrue(0 == testChungus.getTiredness());
		assertFalse(testChungus.canPerformAction());

	}
	
	@Test
	public void searchForPartsTest() {
		assertFalse(testPlanet.partFound());
		testCrew.addCrewMember(testScavenger);
		testScavenger.searchForParts(testPlanet, testCrew);
		assertTrue(testScavenger.getActionsCompleted() == 1);
		assertNotEquals(testScavenger.getMaxTiredness(), testScavenger.getTiredness());
		assertNotEquals(testScavenger.getMaxHunger(), testScavenger.getHunger());

		testPlanet.setPartFound(true);
		testScavenger.searchForParts(testPlanet, testCrew);
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
		assertTrue(testEngineer.getActionsCompleted() == 0);
		assertTrue(testChungus.getActionsCompleted() == 0);
		testEngineer.pilotShip(testChungus, testPlanet, testRandomEvent, testShip);
		
		assertTrue(testEngineer.getActionsCompleted() == 1);
		assertTrue(testChungus.getActionsCompleted() == 1);

	}
	
	@Test
	public void useItemTest() {
		//TEST FOR WHEN HEALTH AND HUNGER ARE ALREADY AT MAX WHEN USING AN ITEM
		//Check if action completed increases
		//Initialise crew member to have health and hunger below maximum amount, also has space plague
		testCrew.addCrewMember(testScavenger);
		
		assertEquals(testScavenger.getHealth(), testScavenger.getMaxHealth());
		assertEquals(testScavenger.getHunger(), testScavenger.getMaxHunger());

		testScavenger.decreaseHealth(80, testCrew);
		testScavenger.increaseHunger();
		testScavenger.setSpacePlague(true);
		
		int beforeFood = testScavenger.getHunger();
		int beforeMedical = testScavenger.getHealth();
		
		//If food item increases hunger
		testScavenger.useItem(testCrew, 0);
		assertTrue(testScavenger.getHunger() > beforeFood);
		
		//Has plague and cures - If medical item increases health/cures space plague
		assertTrue(testScavenger.hasSpacePlague());
		if (testCrew.getItem(0) instanceof MedicalItem) {
			MedicalItem itemChosen = (MedicalItem) testCrew.getItem(0);
			assertTrue(itemChosen.doesCurePlauge());
		}
		
		//Check if the item cures plague
		testScavenger.useItem(testCrew, 0);
		assertTrue(testScavenger.getHealth() > beforeMedical);
		assertFalse(testScavenger.hasSpacePlague());
		
		//If medical item increases health/cures space plague
		assertFalse(testScavenger.hasSpacePlague());
		if (testCrew.getItem(0) instanceof MedicalItem) {
			MedicalItem itemChosen = (MedicalItem) testCrew.getItem(0);
			assertFalse(itemChosen.doesCurePlauge());
		}
				
		//Check if the item cures plague
		testScavenger.useItem(testCrew, 0);
		assertTrue(testScavenger.getHealth() > beforeMedical);
		assertFalse(testScavenger.hasSpacePlague());
	}
	
	
	@Test 
	public void isExhaustedTest() {
		assertEquals(0, testScavenger.getActionsCompleted());
		assertEquals(testScavenger.getMaxTiredness(), testScavenger.getTiredness());
		testScavenger.increaseTiredness();
		
		//Doesn't perform actions but tiredness decreases
		assertEquals(0, testScavenger.getActionsCompleted());
		
		//Not yet exhausted
		assertTrue("" == testScavenger.isExhausted());
		assertNotEquals(testScavenger.getMaxTiredness(),testScavenger.getTiredness());
		
		//Decreasing to tiredness = 0 
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		
		//Before isExhausted is called, actions completed would be less than 2
		assertTrue(2 > testScavenger.getActionsCompleted());
		assertTrue(0 == testScavenger.getTiredness());
		assertEquals(" " + testScavenger.getName() + " is exhausted & cannot perform any more actions today!", testScavenger.isExhausted());
		assertEquals(2, testScavenger.getActionsCompleted());

	}
	
	/**
	 * 
	 */
	@Test
	public void decreaseHealthTest() {
		testCrew.addCrewMember(testRobot);
		
		testRobot.decreaseHealth(10, testCrew);
		assertTrue(testRobot.getHealth() < testRobot.getMaxHealth());
		
		testRobot.decreaseHealth(90, testCrew);
		assertTrue(testRobot.getHealth() == 0);
		
		//Doesn't go to a negative integer
		testRobot.decreaseHealth(10, testCrew);
		assertTrue(testRobot.getHealth() == 0);	
	}
	
	@Test
	public void napTest() {
		//Decreasing to tiredness = 0 
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.increaseTiredness();
		testScavenger.nap();
		assertTrue(testScavenger.getTiredness() == 20);
		assertTrue(testScavenger.getAvailableActions() == (testScavenger.getActionsPerDay() - 1));
	}
	
	
	

}
