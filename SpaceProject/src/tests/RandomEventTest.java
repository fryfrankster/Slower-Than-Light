package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Chungus;
import main.Crew;
import main.Engineer;
import main.RandomEvent;
import main.Scavenger;

class RandomEventTest {
	private RandomEvent testRandomEvent;
	private Crew testCrew;
	private Scavenger testScavenger;
	private Engineer testEngineer;
	private Chungus testChungus;
	
	@BeforeEach
	public void init() {
		testRandomEvent = new RandomEvent();
		testCrew = new Crew("Crew Name");
		testScavenger = new Scavenger("Scavenger");
		testEngineer = new Engineer("Engineer");
		
		testCrew.addCrewMember(testScavenger);
		testCrew.addCrewMember(testScavenger);
		testCrew.addCrewMember(testChungus);
	}
	
	@Test
	public void spacePlagueTest() {
		assertFalse(testScavenger.hasSpacePlague());

		
		
		
		testRandomEvent.spacePlague(testCrew);
		
		
		
//		testScavenger.setSpacePlague(true);
//		assertTrue(testScavenger.hasSpacePlague());
//		testScavenger.setSpacePlague(false);
//		assertFalse(testScavenger.hasSpacePlague());
	}

}
