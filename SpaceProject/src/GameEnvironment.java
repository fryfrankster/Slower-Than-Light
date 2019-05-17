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

	
	private static int crewSelection;
	
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
	
	public Ship getShip() {
		return ship;
	}
	
	public Crew getCrew() {
		return crew;
	}
	
	public int getGameLength() {
		return gameLength;
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
	 * The main loop of the game. Allows users to perform tasks with crewmembers, check statuses, and visit space outposts
	 *  Runs until days are over, all parts are found, or crew is dead.
	 */
	public static void runGame() {
		
		boolean gameRunning = true;
		System.out.println("");
		System.out.println("Welcome to INSERT GAME NAME HERE");
		while(gameRunning && currentDay <= gameLength && crew.getCurrentPieces() != crew.getPiecesToFind() & crew.getCrewSize() != 0 & ship.getCurrentShieldLevel() > 0) {
			int userInput;
			
			System.out.println("");
			System.out.println("Type 1 to view the status of your crew");
			System.out.println("Type 2 to view the status of your spaceship");
			System.out.println("Type 3 to visit the nearest space outpost");
			System.out.println("Type 4 to perform an action with a crewmember");
			System.out.println("Type 5 to view the crew's inventory");
			System.out.println("Type 6 to move onto the next day");
			userInput  = validateInput(1, 6);
			
			switch (userInput) {
			case 1:
				crew.printCurrentMoney();
				crew.printAllStatuses();
				break;
				
			case 2:
				ship.printStatus();
				break;
				
			case 3:
				System.out.println("Choose an action");
				System.out.println("Type 1 to buy items");
				System.out.println("Type 2 to view currently owned items");
				System.out.println("Type 3 to go back");
				System.out.println();
				userInput = validateInput(1, 3);
				switch (userInput) {
				case 1:
					
					if (planet.getPlanetsItemsSize() == 0) {
						System.out.println("There are no items left in the outpost");
					}
					else {
						boolean userChoosing = true;
						while (userChoosing){
							System.out.println("Choose the item you would like to purchase");
							System.out.println("Type the number on the left that corresponds to the item you wish to purchase");
							planet.printPurchasableItems();
							System.out.println("Type " + (planet.getPlanetsItemsSize() + 1) + " to exit buying");
							userInput = validateInput(1, planet.getPlanetsItemsSize() + 1);
							if(userInput == (planet.getPlanetsItemsSize() + 1)){
								userChoosing = false;
							}
							else {
								
							
								crew.purchaseItem(crew, planet, userInput - 1);
							}
						}
					}
					break;
					
					
					
					
					
				case 2:
					crew.viewInventory();
					break;
					
				//User chooses to go back
				case 3:
					break;
				}
				break;
				
				
			
			case 4:
				System.out.println("Enter a number to choose a crewmember");
				crew.printAvailableCrewMembers();
				
				int crewMemberIndex = validateInput(1, crew.getCrewSize()) - 1;
				
				System.out.println("Choose an action for the crewmember");
				System.out.println("Type 1 to sleep");
				System.out.println("Type 2 to search the planet for parts");
				System.out.println("Type 3 to repair the ship");
				System.out.println("Type 4 to pilot the ship to a new planet");
				System.out.println("Type 5 to use an item");
				
				userInput = validateInput(1, 5);
				
				if(crew.getCrewMembers().get(crewMemberIndex).canPerformAction()) {
					switch (userInput) {
					case 1:
						crew.getCrewMembers().get(crewMemberIndex).sleep();
						break;
						
					case 2:
						crew.getCrewMembers().get(crewMemberIndex).searchForParts(planet, crew);
						break;
						
					case 3:
						crew.getCrewMembers().get(crewMemberIndex).repairShields(ship);
						break;
					
					case 4:
						System.out.println("Choose another crewmember to help pilot the ship");
						crew.printAvailableCrewMembers();
						int otherMemberIndex = validateInput(1, crew.getCrewSize()) - 1;
						CrewMember firstMemeber = crew.getCrewMembers().get(crewMemberIndex);
						CrewMember secondMember = crew.getCrewMembers().get(otherMemberIndex);
						if(otherMemberIndex == crewMemberIndex) {
							System.out.println("You must pick a different Crewmember to help pilot the ship!");
						}
						
						else if(secondMember.canPerformAction() == false){
							//System.out.println("This crew member has no actions left!");
						}
						
						else {
							
						
						firstMemeber.pilotShip(secondMember, planet, randomEvent, ship);
						
						}
						
						break;
						
					case 5:
						if (crew.isInventoryEmpty()) {
							System.out.println("There are no items in the inventory");
						}
						else {
							System.out.println("Choose the item you would like to use");
							System.out.println("Type the number on the left that corresponds to the item you wish to use");
							crew.viewInventory();
		
							userInput = validateInput(1, crew.getInventorySize());
							crew.getCrewMembers().get(crewMemberIndex).useItem(crew, userInput);
						}
						
						break;
					
			
					}
				}
				else {
						//System.out.println(crew.getCrewMembers().get(crewMemberIndex).getName() + " Has no actions left! Use a different crew member!");
					}
				
				break;
				
			case 5:
				crew.viewInventory();
				break;
				
				
			case 6:
				nextDay();
				
			}
			
		}
	}
	
	/**
	 * Prints information about the users score and ship
	 */
	public static void endGame() {
		System.out.println("Thanks for playing!");
		System.out.println("Ship: " + ship.getName());
		System.out.println("You found " + crew.getCurrentPieces() + "/" + crew.getPiecesToFind() + " of the ships pieces!");
		System.out.println("You scored " + score + "!");
	}
	
	/**
	 * Starts, runs and ends the game
	 */
	public static void main(String[] args) {
		
		GameEnvironment setupScreen = new GameEnvironment();
		setupScreen.launchSetupScreen();
//		setupGame();
//		runGame();
//		endGame();
	}
	
	/**
	 * Called when the user moves to the next day. Increases the day count, random events may occur, and crews actions
	 * are reset
	 */
	public static void nextDay() {
		currentDay += 1;
		score += crew.getDailyScore();
		randomEvent.alienPirates(crew);
		randomEvent.spacePlague(crew);
		crew.resetCrewActions();
		System.out.println("You have moved onto day " + currentDay + "!");
		
	}
	
	/**
	 * Used to validate users integer inputs when picking options
	 * @param int lowerBound The lowest number the user can pick (inclusive)
	 * @param int UpperBound The highest number the user can pick (inclusive)
	 * @return the integer the user has picked
	 */
	public static int validateInput(int lowerBound, int UpperBound) {
		Scanner scanner = new Scanner(System.in);
		boolean isValid = false;
		int userInput = 0;
		 
		 do {
             System.out.print(">> ");

             try {
            	 userInput = scanner.nextInt();
                 if (userInput >= lowerBound && userInput <= UpperBound) {
                     isValid = true;
                 } else {
                     System.out.println("Not in range. You must select a number between " + lowerBound + " and " + UpperBound);
                     scanner.nextLine();
                 }
             } catch (InputMismatchException exception) {
                 System.out.println("Not a number. You must select a number between " + lowerBound + " and " + UpperBound);
                 scanner.nextLine();
             }

         } while (!(isValid));
		
		 return userInput;
	}
	
	
}

