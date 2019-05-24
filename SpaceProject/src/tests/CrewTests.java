package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Crew;
import main.Engineer;
import main.FoodItem;
import main.GameEnvironment;
import main.Item;
import main.MedicalItem;
import main.Planet;
import main.Scavenger;
import main.Chungus;


/**
 * Tests to check functionality of the Crew class.
 */
class CrewTests {
	private Crew testCrew;
	private Item testItemFood;
	private Item testItemMedical;
	private Scavenger testScavenger;
	private Chungus testChungus;
	private Engineer testEngineer;
	private Planet testPlanet;
	private GameEnvironment testGameEnvironment;
	
	@BeforeEach
	void init() {
	  	testCrew = new Crew ("Crew Name");
	  	testItemFood = new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>");
	  	testItemMedical = new MedicalItem("Medical Kit", 100, 100, "Restores a large amount of health", false);
	  	testScavenger = new Scavenger("Scavanger");
	  	testChungus = new Chungus("Chungus");
	  	testEngineer = new Engineer("Engineer");
	  	testPlanet = new Planet();
	  	testGameEnvironment = new GameEnvironment();
	  	
	}

	/**
	 * Adds an item to the crew. Checks if this increases the crews inventory size and if the item is now in
	 * the crews list of items
	 * @result Crews inventory will contain only testItemFoods
	 */
	@Test
	void addItemTest() {
		testCrew.addItem(testItemFood);
		assertEquals(1, testCrew.getInventorySize());
		assertTrue(testCrew.getItems().contains(testItemFood));
	}
	
	/**
	 * Tests the addition and removal of a crew item.
	 * @result The crews inventory will have no items, and a size of 0
	 */
	@Test
	void removeInInventoryTest() {
		testCrew.addItem(testItemMedical);
		testCrew.removeInInventory(0);
		assertEquals(0, testCrew.getInventorySize());
		assertFalse(testCrew.getItems().contains(testItemMedical));
	}
	
	/**
	 * Adds a crew member of type Scavenger to the crew.
	 * @return the crew should now contain a crew member of type scavenger
	 */
	@Test
	void addCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		assertEquals(1, testCrew.getCrewSize());
		assertTrue(testCrew.getCrewMembers().contains(testScavenger));
	}
	
	/**
	 * Tests adding and removing a crew member from the crew
	 * @result The crew should now be empty and not contain the scavenger added.
	 */
	@Test
	void removeCrewMemberTest() {
		testCrew.addCrewMember(testScavenger);
		testCrew.removeCrewMember(testScavenger);
		assertEquals(0, testCrew.getCrewSize());
		assertFalse(testCrew.getCrewMembers().contains(testScavenger));
	}
	
	/**
	 * Tests decreasing the crews money
	 * @result After decreasing the crews money it is now less than their original amount
	 */
	@Test
	void decreaseMoneyTest() {
		int initialMoney = testCrew.getMoney();
		testCrew.decreaseMoney(1);
		assertTrue(initialMoney > testCrew.getMoney());
		assertFalse(initialMoney < testCrew.getMoney());
	}
	
	/**
	 * Tests increasing the crews money
	 * @result After increasing the crews money it is now more than their original amount
	 */
	@Test
	void addMoneyTest() {
		int initialMoney = testCrew.getMoney();
		testCrew.addMoney(1);
		assertTrue(initialMoney < testCrew.getMoney());
		assertFalse(initialMoney > testCrew.getMoney());
	}
	
	/**
	 * Checks if the crews inventory is empty before and after adding an item
	 * @result The crews inventory should be empty to start with and not empty after adding an item
	 */
	@Test
	void isInventoryEmptyTest() {
		assertTrue(0 == testCrew.getInventorySize());
		assertTrue(testCrew.isInventoryEmpty());
		//Not empty
		testCrew.addItem(testItemFood);
		assertTrue(0 < testCrew.getInventorySize());
		assertFalse(testCrew.isInventoryEmpty());
	}
	
	/**
	 * Tests the availability of crew members before and after performing actions.
	 * @result Only the number of crew members with available actions will be returned from the getAvailableCrewMembers() method
	 */
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
	
	/**
	 * Tests if the crew has enough money to purchase an item, then checks again for another item
	 * @result The crew should be able to purchase the first test item but not the second
	 */
	@Test
	public void canPurchaseItemTest() {
		assertTrue(testItemFood.getPrice() <= testCrew.getMoney());
		assertTrue(testCrew.canPurchaseItem(testCrew, testPlanet, 0));
		
		testCrew.decreaseMoney(testCrew.getMoney());
		
		assertFalse(testItemFood.getPrice() <= testCrew.getMoney());
		assertFalse(testCrew.canPurchaseItem(testCrew, testPlanet, 0));		
	}
	
	
	/**
	 * Tests the purchaseItem() method
	 * @return the crew should be able to purchase the item
	 */
	@Test
	public void purchaseItemTest() {
		testCrew.addMoney(1000);
		testCrew.purchaseItem(testCrew, testPlanet, 0);
		assertTrue(0 < testCrew.getInventorySize());
		
	}
	
	/**
	 * Tests reseting the crews actions works as intended
	 * @result the crew members actions should all be at their daily maximum
	 */
	@Test
	public void resetCrewActionsTest() {
		testCrew.addCrewMember(testChungus);
		testCrew.addCrewMember(testScavenger);
		testCrew.addCrewMember(testEngineer);
		
		
		testCrew.resetCrewActions();
		
		assertEquals(2, testChungus.getAvailableActions());
		assertEquals(2, testScavenger.getAvailableActions());
		assertEquals(2, testEngineer.getAvailableActions());
	}
	
	/**
	 * 
	 * @result
	 */
	@Test
	public void itemsAsStringTest() {
		testCrew.addItem(testItemFood);
		testCrew.addItem(testItemMedical);
		String[] testStringArray = testCrew.getItemsAsStringArray();
		assertEquals(2, testStringArray.length);

	}
	
	/**
	 * Tests that the scoring system works correctly
	 * @result the crews score should now be 100 as the crew member has full health, hunger and tiredness.
	 */
	@Test
	public void getDailyScoreTest() {
		testCrew.addCrewMember(testScavenger);
		assertEquals(100, testCrew.getDailyScore());
	}
	
	@Test
	/**
	 * Checks if the crew finding parts updates their current pieces found.
	 * @result The crew will have only have found all parts when their current pieces equal the pieces to find
	 */
	public void foundAllPartsTest() {
		testCrew.setPiecesToFind(2);
		assertEquals(2, testCrew.getPiecesToFind());
		assertFalse(testCrew.foundAllParts());
		
		
		assertEquals(0, testCrew.getCurrentPieces());
		testCrew.setCurrentPieces(testCrew.getCurrentPieces() + 1);
		assertFalse(testCrew.foundAllParts());
		
		assertEquals(1, testCrew.getCurrentPieces());
		testCrew.setCurrentPieces(testCrew.getCurrentPieces() + 1);
		assertTrue(testCrew.foundAllParts());

	}
	
	@Test
	/**
	 * Adds an item to the crews inventory and checks if the inventory at index 0 is none
	 * @result The item at index 0 at the inventory will not be none
	 */
	public void getItemTest() {
		testCrew.addItem(testItemFood);
		assertNotNull(testCrew.getItem(0));
	}
	

	

}
