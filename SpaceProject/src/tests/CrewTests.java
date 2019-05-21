package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.FoodItem;
import main.Item;
import main.Scavenger;

class CrewTests {
	private Crew testCrew;
	private Item testItemFood;
	private Scavenger testScavenger;
	
	@BeforeEach
	void init() {
	  	testCrew = new Crew ("Crew Name");
	  	testItemFood = new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>");
	  	testScavenger = new Scavenger("Scvanger");
	}

	@Test
	void addItemTest() {
		testCrew.addItem(testItemFood);
		assertEquals(1, testCrew.getInventorySize());
	}
	
	@Test
	void removeInInventoryTest() {
		testCrew.addItem(testItemFood);
		testCrew.removeInInventory(0);
		assertEquals(0, testCrew.getInventorySize());
	}
	
	@Test
	void addCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		assertTrue(testCrew.getCrewMembers().contains(testScavenger));
	}

}
