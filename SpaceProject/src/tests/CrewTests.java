package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.Engineer;
import main.FoodItem;
import main.Item;
import main.MedicalItem;
import main.Planet;
import main.Scavenger;
import main.Chungus;


//Test that two of the same crew type class can be added to the crew members list
class CrewTests {
	private Crew testCrew;
	private Item testItemFood;
	private Item testItemMedical;
	private Scavenger testScavenger;
	private Chungus testChungus;
	private Engineer testEngineer;
	private Planet testPlanet;
	
	@BeforeEach
	void init() {
	  	testCrew = new Crew ("Crew Name");
	  	testItemFood = new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>");
	  	testItemMedical = new MedicalItem("Medical Kit", 100, 100, "Restores a large amount of health", false);
	  	testScavenger = new Scavenger("Scavanger");
	  	testChungus = new Chungus("Chungus");
	  	testEngineer = new Engineer("Engineer");
	  	testPlanet = new Planet();
	  	
	}

	@Test
	void addItemTest() {
		testCrew.addItem(testItemFood);
		assertEquals(1, testCrew.getInventorySize());
		assertTrue(testCrew.getItems().contains(testItemFood));
	}
	
	@Test
	void removeInInventoryTest() {
		testCrew.addItem(testItemMedical);
		testCrew.removeInInventory(0);
		assertEquals(0, testCrew.getInventorySize());
		assertFalse(testCrew.getItems().contains(testItemMedical));
	}
	
	@Test
	void addCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		assertEquals(1, testCrew.getCrewSize());
		assertTrue(testCrew.getCrewMembers().contains(testScavenger));
	}
	
	@Test
	void removeCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		testCrew.removeCrewMember(testScavenger);
		assertEquals(0, testCrew.getCrewSize());
		assertFalse(testCrew.getCrewMembers().contains(testScavenger));
	}
	
	@Test
	void decreaseMoneyTest() {
		int initialMoney = testCrew.getMoney();
		testCrew.decreaseMoney(1);
		assertTrue(initialMoney > testCrew.getMoney());
		assertFalse(initialMoney < testCrew.getMoney());
	}
	
	@Test
	void addMoneyTest() {
		int initialMoney = testCrew.getMoney();
		testCrew.addMoney(1);
		assertTrue(initialMoney < testCrew.getMoney());
		assertFalse(initialMoney > testCrew.getMoney());
	}
	
	@Test
	void isInventoryEmptyTest() {
		assertTrue(0 == testCrew.getInventorySize());
		assertTrue(testCrew.isInventoryEmpty());
		//Not empty
		testCrew.addItem(testItemFood);
		assertTrue(0 < testCrew.getInventorySize());
		assertFalse(testCrew.isInventoryEmpty());
	}
	
	@Test
	void getAvailableCrewMembersTest() {
		assertTrue(0 == testCrew.getAvailableCrewMembers());
		
		testCrew.addCrewMember(testChungus);
		
		testChungus.setActionsCompleted(0);
		assertTrue(1 == testCrew.getAvailableCrewMembers());
		assertNotEquals(0, testCrew.getAvailableCrewMembers());
		
		testChungus.setActionsCompleted(1);
		assertTrue(1 == testCrew.getAvailableCrewMembers());
		assertFalse(0 == testCrew.getAvailableCrewMembers());
		assertFalse(2 == testCrew.getAvailableCrewMembers());
		
		testChungus.setActionsCompleted(2);
		assertTrue(0 == testCrew.getAvailableCrewMembers());
		assertFalse(1 == testCrew.getAvailableCrewMembers());
	}
	
	@Test
	public void canPurchaseItemTest() {
		assertTrue(testItemFood.getPrice() <= testCrew.getMoney());
		testCrew.decreaseMoney(50);
		assertTrue(testItemFood.getPrice() >= testCrew.getMoney());
	}
	
	@Test
	public void purchaseItemTest() {
		testCrew.addMoney(1000);
		testCrew.purchaseItem(testCrew, testPlanet, 0);
		assertTrue(0 < testCrew.getInventorySize());
		
	}
	
	@Test
	public void resetCrewActionsTest() {
		testCrew.addCrewMember(testChungus);
		testCrew.addCrewMember(testScavenger);
		testCrew.addCrewMember(testEngineer);
		
		testChungus.setActionsCompleted(0);
		testScavenger.setActionsCompleted(1);
		testEngineer.setActionsCompleted(2);
	}
	
	@Test
	public void itemsAsStringTest() {
		testCrew.addItem(testItemFood);
		testCrew.addItem(testItemMedical);
		testCrew.getItemsAsStringArray();
		
		
	}

}
