package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Chungus;
import main.Crew;
import main.Engineer;
import main.Item;
import main.MedicalItem;
import main.RandomEvent;
import main.Scavenger;
import main.Ship;

/**
 * Tests functionality of the Random Event class
 */
class RandomEventTest {
	private RandomEvent testRandomEvent;
	private Crew testCrew;
	private Scavenger testScavenger;
	private Engineer testEngineer;
	private Chungus testChungus;
	private Ship testShip;
	
	
	@BeforeEach
	public void init() {
		testRandomEvent = new RandomEvent();
		testCrew = new Crew("Crew Name");
		testScavenger = new Scavenger("Scavenger");
		testEngineer = new Engineer("Engineer");
		testShip = new Ship("Ship");
		
		testCrew.addCrewMember(testScavenger);
		testCrew.addCrewMember(testEngineer);
		testCrew.addCrewMember(testChungus);
		
		testCrew.addItem(new MedicalItem("Alien antibiotics", 75, 25, "Cures space plague and restores health ", true));
	}
	
	@Test
	public void spacePlagueTest() {
		assertFalse(testScavenger.hasSpacePlague());
		testScavenger.setSpacePlague(true);

		
		testRandomEvent.spacePlague(testCrew);
				
		//May or many not pass as this is a random event
		assertTrue(testScavenger.hasSpacePlague());
		assertTrue(testEngineer.hasSpacePlague());
		assertTrue(testChungus.hasSpacePlague());
	}
	
	@Test
	public void asteroidBeltTest() {
		assertEquals(testShip.getMaxShieldLevel(), testShip.getCurrentShieldLevel());
		testRandomEvent.asteroidBelt(testShip);
		
		//May or many not pass as this is a random event
		assertNotEquals(testShip.getMaxShieldLevel(), testShip.getCurrentShieldLevel());

		
	}
	
	@Test
	public void alienPiratesTest() {
		assertNotNull(testCrew.getItems());
		
		int initialInventorySize = testCrew.getInventorySize();
		ArrayList<Item> intialInventory = new ArrayList<Item>(testCrew.getItems());
		
		//The same but not identical
		assertTrue(intialInventory.equals(testCrew.getItems()));
		
		testRandomEvent.alienPirates(testCrew);
		
		//May or may not pass
		assertNotEquals(intialInventory, testCrew.getItems());
		assertNotEquals(initialInventorySize, testCrew.getInventorySize());
		
	}
}
