package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;
import main.Planet;

/**
 * Tests functionality of the Planet class
 *
 */
class PlanetTest {
	private Planet testPlanet;
	
	@BeforeEach
	public void init() {
		testPlanet = new Planet();
	}
	
	/**
	 * Checks if the only transporter part available on the planet has been found
	 */
	@Test
	public void partFoundTest() {
		assertFalse(testPlanet.partFound());
		testPlanet.setPartFound(true);
		assertTrue(testPlanet.partFound());
	}
	
	/**
	 * Removes an item from the outpost
	 * @result planetItems has one less item given the item chosen to be removed
	 */
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
