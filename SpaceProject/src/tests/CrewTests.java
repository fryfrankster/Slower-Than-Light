package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.FoodItem;
import main.Item;
import main.Scavenger;
import main.Chungus;


//Test that two of the same crew type class can be added to the crew members list
class CrewTests {
	private Crew testCrew;
	private Item testItemFood;
	private Scavenger testScavenger;
	private Chungus testChungus;
	
	@BeforeEach
	void init() {
	  	testCrew = new Crew ("Crew Name");
	  	testItemFood = new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>");
	  	testScavenger = new Scavenger("Scavanger");
	  	testChungus = new Chungus("Chungus");
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
	
	@Test
	void removeCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		assertTrue(testCrew.getCrewMembers().contains(testScavenger));
		testCrew.removeCrewMember(testScavenger);
		assertFalse(testCrew.getCrewMembers().contains(testScavenger));
	}
	
	@Test
	void decreaseMoneyTest() {
		int initialMoney = testCrew.getMoney();
		testCrew.decreaseMoney(1);
		assertTrue(initialMoney > testCrew.getMoney());
	}

}
