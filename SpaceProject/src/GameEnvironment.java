import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameEnvironment {

	/** The current day the player is on */
	private static int currentDay;
	
	/** The number of days the player has selected to play for */
	private static int gameLength;
	
	/** The number of pieces the player has found of the ship */
	//private static int currentPieces;
	
	/** The total number of ship pieces the player has to find */
	//private static int piecesToFind;
	
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
	
	private String reasonForEnding;

	public String getReasonForEnding() {
		return reasonForEnding;
	}

	public void setReasonForEnding(String reasonForEnding) {
		this.reasonForEnding = reasonForEnding;
	}

	public RandomEvent getRandomEvent() {
		return randomEvent;
	}
	
	private static int crewSelection;
	
	public int getScore() {
		return score;
	}
	
	public void launchSetupScreen() {
		SetupScreen setupScreen = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupScreen) {
		setupScreen.closeWindow();
	}
	
	public void launchCrewSelectionScreen() {
		CrewSelectionScreen crewSelectionScreen = new CrewSelectionScreen(this);
	}
	
	public void closeCrewSelectionScreen(CrewSelectionScreen crewSelectionScreen) {
		crewSelectionScreen.closeWindow();
	}
	
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
	}
	
	public void launchEndScreen() {
		EndScreen endScreen = new EndScreen(this);
	}
	
	public void closeEndScreen(EndScreen endScreen) {
		endScreen.closeWindow();
	}
	
	public void launchInventoryScreen() {
		InventoryScreen inventoryScreen = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
	}
	
	public void launchOutpostScreen() {
		OutpostScreen outpostScreen = new OutpostScreen(this);
	}
	
	public void closeOutpostScreen(OutpostScreen outpostScreen) {
		outpostScreen.closeWindow();
	}
	
	public Ship getShip() {
		return ship;
	}
	
	public Crew getCrew() {
		return crew;
	}
	
	public int getGameLength() {
		return gameLength;
	}
	
	public int getCurrentDay() {
		return currentDay;
	}
	
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

