package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import gui.CrewSelectionScreen;
import gui.InventoryScreen;
import gui.MainScreen;
import gui.OutpostScreen;
import gui.SetupScreen;

/**
 * Holds game logic and initializes key classes such as the crews ship, crew and planet
 */
public class GameEnvironment {

	/** The current day the player is on */
	private static int currentDay;
	
	/** The number of days the player has selected to play for */
	private static int gameLength;
	
	/** The players crew */
	private static Crew crew;
	
	/** An object of the RandomEvent class used to call random events */
	private static RandomEvent randomEvent;
	
	/** The players ship */
	private static Ship ship;
	
	/** An object of the planet class used for buying items and searching for parts */
	private static Planet planet;
	
	/** The players current score */
	private static int score;
	
	/**A string describing the reason why the game ended*/
	private String reasonForEnding;

	/**
	 * Returns a string describing the reason why the game ended
	 * @return a string describing the reason why the game ended
	 */
	public String getReasonForEnding() {
		return reasonForEnding;
	}

	/**
	 * Sets the reason for ending the game
	 * @param String reasonForEnding A String describing to the user why the game ended
	 */
	public void setReasonForEnding(String reasonForEnding) {
		this.reasonForEnding = reasonForEnding;
	}

	/**
	 * Gets the instance of the random event class used to make random events happen in game
	 * @return the instance of the random event class
	 */
	public RandomEvent getRandomEvent() {
		return randomEvent;
	}
	

	/**
	 * Returns the users score
	 * @return an integer showing the users score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Launches the Setup GUI
	 */
	public void launchSetupScreen() {
		SetupScreen setupScreen = new SetupScreen(this);
	}
	
	/**
	 * Closes the Setup Screen GUI
	 * @param SetupScreen setupScreen the screen to be closed
	 */
	public void closeSetupScreen(SetupScreen setupScreen) {
		setupScreen.closeWindow();
	}
	
	/**
	 * Launches the Crew Selection GUI
	 */
	public void launchCrewSelectionScreen() {
		CrewSelectionScreen crewSelectionScreen = new CrewSelectionScreen(this);
	}
	
	/**
	 * Closes the Crew Selection GUI
	 *  @param CrewSelectionScreen crewSelectionScreen the screen to be closed
	 */
	public void closeCrewSelectionScreen(CrewSelectionScreen crewSelectionScreen) {
		crewSelectionScreen.closeWindow();
	}
	
	/**
	 * Launches the Main Screen GUI
	 */
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	
	/**
	 * Closes the Main Screen GUI
	 * @param MainScreen mainScreen the screen to be closed
	 */
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	/**
	 * Launches the End Screen GUI
	 */
	public void launchEndScreen() {
		EndScreen endScreen = new EndScreen(this);
	}
	
	/**
	 * Closes the End Screen GUI
	 * @param EndScreen endScreen the screen to be closed
	 */
	public void closeEndScreen(EndScreen endScreen) {
		endScreen.closeWindow();
	}
	
	/**
	 * Launches the Inventory Screen GUI
	 */
	public void launchInventoryScreen() {
		InventoryScreen inventoryScreen = new InventoryScreen(this);
	}
	
	
	/**
	 * Closes the Inventory Screen GUI
	 * @param InventoryScreen inventoryScreen the screen to be closed
	 */
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
	}
	
	
	public void launchOutpostScreen() {
		OutpostScreen outpostScreen = new OutpostScreen(this);
	}
	

	/**
	 * Closes the Outpost Screen GUI
	 * @param OutpostScreen outpostScreen the screen to be closed
	 */
	public void closeOutpostScreen(OutpostScreen outpostScreen) {
		outpostScreen.closeWindow();
	}
	
	/**
	 * Returns the ship the player has
	 * @return the ship the player has
	 */
	public Ship getShip() {
		return ship;
	}
	
	/**
	 * Returns the Crew the player has
	 * @return the crew the player has
	 */
	public Crew getCrew() {
		return crew;
	}
	
	/**
	 * Returns the number of days the game runs for
	 * @return an integer showing the number of days the game runs for
	 */
	public int getGameLength() {
		return gameLength;
	}
	
	/**
	 * Returns the current day the player is on
	 * @return the current day the player is on
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * Returns the planet the player is on
	 * @return the planet the player is on
	 */
	public Planet getPlanet() {
		return planet;
	}
	
	/**
	 * Called when the user moves to the next day. Increases the day count, random events may occur, and crews actions
	 * are reset
	 */
	public String nextDay() {
		currentDay += 1;
		score += crew.getDailyScore();
		crew.resetCrewActions();
		return "Day: " + currentDay + randomEvent.spacePlague(crew) + randomEvent.alienPirates(crew);
		
	}
	
	
	/**
	 * Gets the user to pick a name for ship, choose crew members and initializes key game variables to starting values
	 */
	public void setupGame(String shipName, String crewName, int numDays) {
		 score = 0;
		 randomEvent = new RandomEvent();
		 currentDay = 1;
		 
		 ship = new Ship(shipName);
		 crew = new Crew(crewName);
		 gameLength = numDays;

		 planet = new Planet();
		 crew.setPiecesToFind((int) Math.floor(2d/3d * gameLength)); 
	}
	
	
	/**
	 * Launches the game
	 */
	public static void main(String[] args) {
		
		GameEnvironment setupScreen = new GameEnvironment();
		setupScreen.launchSetupScreen();

	}
	
	
	
}

