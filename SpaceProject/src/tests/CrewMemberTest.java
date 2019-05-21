package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Chungus;
import main.Engineer;
import main.Scavenger;
import main.Robot;
import main.Soldier;
import main.Worker;

class CrewMemberTest {
	private Chungus testChungus;
	private Engineer testEngineer;
	private Scavenger testScavenger;
	private Robot testRobot;
	private Worker testWorker;
	private Soldier testSoldier;
	
	@BeforeEach
	void init() {
		testChungus = new Chungus("Chungus");
		testEngineer = new Engineer("Engineer");
		testScavenger = new Scavenger("Scavenger");
		testRobot = new Robot("Robot");
		testWorker = new Worker("Worker");
		testSoldier = new Soldier("Soldier");
	}
	
	

}
