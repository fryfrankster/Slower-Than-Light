package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;
import main.Planet;

class PlanetTest {
	private Planet testPlanet;
	@BeforeEach
	
	public void init() {
		testPlanet = new Planet();
	}
	
	@Test
	public void partFoundTest() {
		assertFalse(testPlanet.partFound());
		testPlanet.setPartFound(true);
		assertTrue(testPlanet.partFound());
	}
	
	@Test
	public void removeItemTest() {
		int intialPlanetItemsSize = testPlanet.getPlanetsItemsSize();
		ArrayList<Item> initialPlanetItems = new ArrayList<Item>(testPlanet.getPlanetsItems());
		
		//The same but not identical
		assertTrue(initialPlanetItems.equals(testPlanet.getPlanetsItems()));

		testPlanet.removeItem(0);
		assertNotEquals(initialPlanetItems, testPlanet.getPlanetsItems());
		assertNotEquals(intialPlanetItemsSize, testPlanet.getPlanetsItemsSize());
		
		//Remove item when there are no more items left
	}
	
	@Test
	public void getAllItemsTest() {
		assertNotNull(testPlanet.getAllItems());
	}

}