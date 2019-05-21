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
		
//		Comparing array lists
//		ArrayList<Item> initialPlanetItems = new ArrayList<Item>();
//		initialPlanetItems.copy(initialPlanetItems, testPlanet.getPlanetsItems());
		
		assertEquals(intialPlanetItemsSize, testPlanet.getPlanetsItemsSize());
		testPlanet.removeItem(0);
		assertTrue(intialPlanetItemsSize > testPlanet.getPlanetsItemsSize());
	}
	

}
