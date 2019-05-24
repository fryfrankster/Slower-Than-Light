package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Chungus;
import main.Engineer;
import main.FoodItem;
import main.Item;
import main.MedicalItem;
import main.Planet;
import main.RandomEvent;
import main.Scavenger;
import main.Ship;
import main.Robot;
import main.Soldier;
import main.Worker;
import main.Crew;

/**
 * Tests created to test functionality of the CrewMember class.
 */
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

	/**
	 * Checking the types of crew members that are immune to space plague
	 * @result Plague immune variable is returned given the type of crew member
	 */
	@Test
	public void isPlagueImmuneTest() {
		assertTrue(testRobot.isPlaugeImmune());
		//Check that other types are not plague immune
		assertFalse(testChungus.isPlaugeImmune());
		assertFalse(testScavenger.isPlaugeImmune());
		assertFalse(testWorker.isPlaugeImmune());
		assertFalse(testSoldier.isPlaugeImmune());
		assertFalse(testEngineer.isPlaugeImmune());
	}
	
	/**
	 * Checks the type of the crew member
	 * @result Type of the crew member will be returned
	 */
	@Test
	public void getTypeTest() {
		assertEquals(testScavenger.getType(), "Scavenger");
		assertEquals(testEngineer.getType(), "Engineer");
		assertEquals(testRobot.getType(), "Robot");
		assertEquals(testChungus.getType(), "Chungus");
		assertEquals(testWorker.getType(), "Worker");
		assertEquals(testSoldier.getType(), "Soldier");

	}	
	
	/**
	 * Checking if a crew member can perform an action based on the number of actions left and
	 * their tiredness levels
	 * @result Returns a boolean to determine if crew member can perform an action
	 */
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
		assertEquals(0, testChungus.getTiredness());
		assertFalse(testChungus.canPerformAction());
		
		
		testChungus.setActionsCompleted(0);
		assertEquals(0, testChungus.getTiredness());
		assertFalse(testChungus.canPerformAction());
		
		testChungus.setActionsCompleted(1);
		assertEquals(0, testChungus.getTiredness());
		assertFalse(testChungus.canPerformAction());

	}
	
	/**
	 * Performs search for parts
	 * @result Will return either a transporter part, an item, money or nothing if the search was unsuccessful
	 */
	@Test
	public void searchForPartsTest() {
		assertFalse(testPlanet.partFound());
		testCrew.addCrewMember(testScavenger);
		testScavenger.searchForParts(testPlanet, testCrew);
		assertTrue(testScavenger.getActionsCompleted() == 1);
		assertNotEquals(testScavenger.getMaxTiredness(), testScavenger.getTiredness());
		assertNotEquals(testScavenger.getMaxHunger(), testScavenger.getHunger());
		
		/**Finding another transporter part will be disabled if one has already been found on the planet*/
		testPlanet.setPartFound(true);
		testScavenger.searchForParts(testPlanet, testCrew);
	}
	
	
	/**
	 * Perform sleep action based on tiredness
	 * @result Tiredness level of the crew member will increase
	 */
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
	
	/**
	 * Performs repair shields action based on the current shield level of the ship
	 * @result Shield level of the ship will increase
	 */
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
	
	
	/**
	 * Performs pilot ship to a new planet
	 * @result Planet will be reset and planet items in the outpost will generate a new random collection of items available for purchase
	 */
	@Test 
	public void pilotShipTest() {
		ArrayList<Item> initialPlanetItems = new ArrayList<Item>(testPlanet.getPlanetsItems());
		
		testCrew.addCrewMember(testChungus);
		testCrew.addCrewMember(testEngineer);
		assertTrue(testCrew.getAvailableCrewMembers() == 2);
		
		assertTrue(testEngineer.getActionsCompleted() == 0);
		assertTrue(testChungus.getActionsCompleted() == 0);
		testEngineer.pilotShip(testChungus, testPlanet, testRandomEvent, testShip);
		
		assertTrue(testEngineer.getActionsCompleted() == 1);
		assertTrue(testChungus.getActionsCompleted() == 1);
		assertNotEquals(testEngineer.getHunger(), testEngineer.getMaxHunger());
		assertNotEquals(testChungus.getTiredness(), testChungus.getMaxTiredness());
		
		/**New planet would initialise random items that differ from the previous planet*/
		assertNotEquals(initialPlanetItems, testPlanet.getPlanetsItems());
	}
	
	/**
	 * Performs use item, based on the item type, the hunger/health of the crew member will
	 * increase and can cure space plague
	 * @result Crew member health or hunger will increase and may cure space plague if contracted depending on the item used
	 */
	@Test
	public void useItemTest() {
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
	
	
	/**
	 * Checks if the crew member's tiredness levels are at 0 based on the current tiredness level
	 * @result Crew member cannot perform any more actions on the day and is forced to take a nap the next day
	 */
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
	 * Decrease crew member's health
	 * @result Health of crew member will decrease
	 */
	@Test
	public void decreaseHealthTest() {
		testCrew.addCrewMember(testRobot);
		assertEquals(testRobot.getHealth(), testRobot.getMaxHealth());
		
		testRobot.decreaseHealth(10, testCrew);
		assertTrue(testRobot.getHealth() < testRobot.getMaxHealth());
		
		testRobot.decreaseHealth(90, testCrew);
		assertTrue(testRobot.getHealth() == 0);
		
		//Doesn't go to a negative integer
		testRobot.decreaseHealth(10, testCrew);
		assertTrue(testRobot.getHealth() == 0);	
	}
	
	/**
	 * Increase crew member's health
	 * @result Health of crew member will increase
	 */
	@Test
	public void increaseHealthTest() {
		testCrew.addCrewMember(testRobot);
		assertEquals(testRobot.getHealth(), testRobot.getMaxHealth());
		
		testRobot.decreaseHealth(testRobot.getMaxHealth(), testCrew);
		assertTrue(testRobot.getHealth() < testRobot.getMaxHealth());
		
		testRobot.increaseHealth(testRobot.getMaxHealth());
		assertEquals(testRobot.getHealth(), testRobot.getMaxHealth());
		
		//Doesn't go to a negative integer
		testRobot.increaseHealth(10);
		assertEquals(testRobot.getHealth(), testRobot.getMaxHealth());
	}
	
	/**
	 * Performs a nap if tiredness level is at 0
	 * @result Tiredness level will increase by 20 and counts as 1 action performed
	 */
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
