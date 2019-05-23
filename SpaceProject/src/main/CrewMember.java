package main;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Stores information about a specific Crew member. Also contains methods representing actions the crew member can make
 */
public class CrewMember {
	/**The name of the crew member */
	private String name;
	
	/** The maximum amount of health of the crew member */
	private int maxHealth;
	
	/** The crew members current health */
	private int currentHealth;
	
	/** The maximum amount of hunger the crew member has max hunger means the crew member is fully sated*/
	private int maxHunger;
	
	/**How hungry the crew member currently is */
	private int currentHunger;
	
	/** The crew members current tiredness */
	private int currentTiredness;
	
	/** The crew members maximum tiredness */
	private int maxTiredness;
	
	/**The rate at which the crew members hunger increases when they perform an action */
	private int hungerIncreaseRate;
	
	/**The rate at which the crew members tiredness increases when they perform an action */
	private int tirednessIncreaseRate;
	
	/**The amount of actions the crew member has completed on the current day */
	private int actionsCompleted;
	
	/**An integer representing how skilled the crew member is at searching the planet. A higher value means more skill */
	private int searchSkill;
	
	/**An integer representing how skilled the crew member is at repairing the ship. A higher value means more skill */
	private int repairSkill;
	
	/** A boolean representing if the crew member is immune to the space plague */
	private boolean plagueImmune;
	
	/** A boolean representing if the crew member has the space plague */
	private boolean hasPlague;
	
	/** The number of actions the crew member can perform in a day */
	private int actionsPerDay;
	
	/** The type of the crew member */
	private String type;

	/**
	 * 
	 * @param String name the name of the crew member
	 * @param int maxHealth The maximum amount of health of the crew member 
	 * @param int hungerIncreaseRate The rate at which the crew members hunger increases when they perform an action
	 * @param int tirednessIncreaseRate The rate at which the crew members Tiredness increases when they perform an action
	 * @param int searchSkill An integer representing how skilled the crew member is at searching the planet. A higher value means more skill
	 * @param int repairSkill An integer representing how skilled the crew member is at piloting the ship. A higher value means more skill
	 * @param boolean plagueImmune A boolean representing if the crew member is immune to the space plague
	 * @param int actionsPerDay The number of actions the crew member can perform in a day
	 * @param String type The type of the crew member 
	 */
	public CrewMember(String name, int maxHealth, int hungerIncreaseRate, int tirednessIncreaseRate, int searchSkill, int repairSkill, boolean plagueImmune,  int actionsPerDay, String type) {
		this.name = name;
		this.currentHealth = this.maxHealth = maxHealth;
		currentHunger = maxHunger = currentTiredness = maxTiredness = 100;
		this.hungerIncreaseRate = hungerIncreaseRate;
		this.tirednessIncreaseRate = tirednessIncreaseRate;
		this.searchSkill = searchSkill;
		this.repairSkill = repairSkill;
		this.plagueImmune = plagueImmune;
		this.actionsPerDay = actionsPerDay;
		this.type = type;
		actionsCompleted = 0;
		hasPlague = false;
		
	}
	
	
	/**
	 * Checks if the crew member has the space plague
	 * @return a boolean showing if the crew member has space plague
	 */
	public boolean hasSpacePlague() {
		return hasPlague;
	}
	
	/**
	 * Returns the number actions the crew member can perform
	 * @return the number of actions the crew member can perform
	 */
	public int getActionsPerDay() {
		return actionsPerDay;
	}
	
	/**
	 * Returns a boolean showing whether the crew member is plague immune 
	 * @return true if crew member is plague immune, false otherwise
	 */
	public boolean isPlaugeImmune() {
		return plagueImmune;
	}
	
	
	/**
	 * Decreases a crew members health by a specified amount, calls crewMemberDeath if the members health drops to 0
	 * @param int toDecrease the amount of health to decrease the crew member by
	 * @param Crew crew the crew the crew member is from
	 */
	public void decreaseHealth(int toDecrease, Crew crew) {
		currentHealth = Math.max(currentHealth - toDecrease, 0);
		if(currentHealth == 0) {
			crewMemberDeath(crew);
		}
	}
	
	/**
	 * Increases the crew members tiredness by their specified tiredness increase rate
	 */
	public void increaseTiredness() {
		currentTiredness = Math.max(0, currentTiredness - tirednessIncreaseRate);
		
	}
	
	
	/**
	 * Decreases the crew members current hunger by their hunger increase rate
	 */
	public void increaseHunger() {
		currentHunger = Math.max(0, currentHunger - hungerIncreaseRate);
	}
	
	
	/**
	 * Returns the number of actions the crew member has completed that day
	 * @return the number of actions the crew member has completed that day
	 */
	public int getActionsCompleted() {
		return actionsCompleted;
	}
	
	/**
	 * Sets the number of crew members actions completed to the given value
	 * @param int actions the number of actions the crew member has now completed
	 */
	public void setActionsCompleted(int actions) {
		actionsCompleted = actions;
	}
	
	/**
	 * Returns the number of available actions the crew member has
	 * @return an integer showing the number of available actions the crew member has
	 */
	public int getAvailableActions() {
		return actionsPerDay - actionsCompleted;
	}
	
	/**
	 * Called when a crew member dies, removes them from the crew
	 * @param Crew crew the crew that the dying crew member is from
	 */
	public void crewMemberDeath(Crew crew) {
		crew.removeCrewMember(this);
	}
	
	/**
	 * Returns the name of the crew member
	 * @return the name of the crew member
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Increases the health of the crew member by the specified value
	 * @param int increase the amount of health to increase the crew member by
	 */
	public void increaseHealth(int increase) {
		currentHealth = Math.min(maxHealth, currentHealth + increase);
	}
	
	/**
	 * Returns the crew members current hunger
	 * @return the crew members current hunger
	 */
	public int getHunger() {
		return currentHunger;
	}
	
	
	/**
	 * Returns the crew members current health
	 * @return the crew members current health
	 */
	public int getHealth() {
		return currentHealth;
	}
	
	/**
	 * Returns the crew members maximum health
	 * @return the crew members maximum health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Returns the crew members current tiredness
	 * @return the crew members current tiredness
	 */
	public int getTiredness() {
		return currentTiredness;
	}
	
	
	/**
	 * Returns the crew members maximum hunger
	 * @return the crew members maximum hunger
	 */
	public int getMaxHunger() {
		return maxHunger;
	}
	
	
	/**
	 * Returns the crew members maximum tiredness
	 * @return the crew members maximum tiredness
	 */
	public int getMaxTiredness() {
		return maxTiredness;
	}
	
	
	/**
	 * Returns a boolean showing whether the crew member can perform an action
	 * @return true if the crew member can perform an action, false otherwise
	 */
	public boolean canPerformAction() {
		return (actionsCompleted < actionsPerDay && currentTiredness != 0);
	}
	
	
	/**
	 * Returns the type of the crew member
	 * @return the crew members type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gives a crew member space plague or cures them of it
	 * @param boolean plague a boolean value, true if the member is given plague, false if the member is cured.
	 */
	public void setSpacePlague(boolean plague) {
		hasPlague = plague;
	}
	
	/**
	 * Checks if a crew member has reached maximum tiredness. Will not be able to perform an action if member is exhausted.
	 * @return exhausted a boolean value, true if the member is exhausted, false if the member is not exhausted.
	 */
	public String isExhausted() {
		if (currentTiredness == 0) {
			setActionsCompleted(actionsPerDay);
			return " " + name + " is exhausted & cannot perform any more actions today!";
		}
		
		return "";
	}
	
	/**
	 * Called when a crew member has reached maximum tiredness, slightly increases their sleep level 
	 * and sets their available actions to 1
	 */
	public void nap() {
		currentTiredness += 20;
		setActionsCompleted(1);
	}
	
	
	/**
	 * A crew member uses an item. The crew member benefits from the item and it is removed from the crews inventory
	 * @param Crew crew the crew the crew member is from
	 * @param int userInput an integer representing the item the player has chosen to use
	 * @return the result of using the item to be displayed to the user
	 */
	public String useItem(Crew crew, int userInput) {
		String outputToUser = "";
		if(crew.getItem(userInput) instanceof MedicalItem){
			MedicalItem itemChosen = (MedicalItem) crew.getItem(userInput);
			currentHealth = Math.min(currentHealth + itemChosen.getBenefit(), maxHealth);
			outputToUser += name + " has used " + itemChosen.getName() + "!";
			
			if(itemChosen.doesCurePlauge() && hasPlague) {
				hasPlague = false;
				outputToUser += " They have been cured of the space plague!";
			};
		}
		else {
			FoodItem itemChosen = (FoodItem) crew.getItem(userInput);
			currentHunger = Math.min(currentHunger + itemChosen.getBenefit(), maxHunger);
			outputToUser += name + " has eaten " + itemChosen.getName() + "!";
		}
			

		actionsCompleted += 1;
		
		crew.removeInInventory(userInput);
		
		increaseTiredness();
		
		
		return outputToUser + isExhausted();
		
	}
	
	/**
	 * Decreases the crew members tiredness, uses an action and increases hunger
	 * @return A string showing the result of the action to be displayed to the user
	 */
	public String sleep(){
		if(currentTiredness == maxTiredness) {
			return name + " is not tired!";
		}
		actionsCompleted += 1;
		increaseHunger();
		currentTiredness = maxTiredness;
		return name + " has slept";
	}
	
	/**
	 * Uses two crew members to pilot the ship to another planet
	 * @param CrewMember otherMember The other crew member piloting the ship
	 * @param Planet planet The planet the crew member is currently on
	 * @param RandomEvent randomEvent instance of random event used to create the asteroid event
	 * @param Ship ship the ship to be piloted
	 * @return A string showing the result of the action to be displayed to the user
	 */
	public String pilotShip(CrewMember otherMember, Planet planet, RandomEvent randomEvent, Ship ship) {
		actionsCompleted += 1;
		otherMember.actionsCompleted += 1;
		increaseHunger();
		otherMember.increaseHunger();
		increaseTiredness();
		otherMember.increaseTiredness();
		planet.newPlanet();
		return name + " and " + otherMember.name + " have piloted the ship to a new planet. " + randomEvent.asteroidBelt(ship) + isExhausted() + otherMember.isExhausted();
	}

	/**
	 * Repairs the ships shields by the crew members specified repair skill
	 * @param Ship ship the ship to be repaired
	 * @return A string showing the result of the action to be displayed to the user
	 */
	public String repairShields(Ship ship) {
		if(ship.getCurrentShieldLevel() == ship.getMaxShieldLevel()) {
			return "The shields are already at full health!";
		}
		else {
		ship.setShieldLevel(Math.min(ship.getMaxShieldLevel(), ship.getCurrentShieldLevel() + repairSkill));
		increaseHunger();
		increaseTiredness();
		actionsCompleted += 1;
		return name + " has repaired the ships shields" + isExhausted();
		}
	}
	
	/** 
	 * A crew member searches the planet for parts. They are able to find a spaceship part, an item, money or nothing
	 * @param Planet planet the planet to be searched
	 * @param Crew crew the crew that the member is from
	 * @return A string showing the result of the action to be displayed to the user
	 */
	public String searchForParts(Planet planet, Crew crew) {
		increaseHunger();
		increaseTiredness();
		actionsCompleted += 1;
		String result = "";
		
		Random random = new Random();
		int searchingFor;
		
		//If the part has been found don't search for it again
		if(planet.partFound()) {
			searchingFor = random.nextInt(2);
		}
		
		else {
			searchingFor = random.nextInt(3);
		}
		
		boolean searchSuccess = false;
		
		//Chooses a random number between 0 and 100
		int searchScore = random.nextInt(101);
		
		//Randomly chooses what the CrewMember is searching for
		switch(searchingFor) {
			
			//Finding money
			case 0:
				if((searchScore + searchSkill) > 30){
					int moneyGained = random.nextInt(60);
					crew.addMoney(moneyGained);
					searchSuccess = true;
					result = name + " found $" + moneyGained;
					break;
				}
				
				//Finding an item
			case 1:
				if((searchScore + searchSkill) > 50){
					int itemIndex = random.nextInt(planet.getNumTotalItems());
					Item itemFound = planet.getAllItems().get(itemIndex);
					crew.addItem(itemFound);
					result = name + " found " + itemFound.getName() + " of type " + itemFound.getType();
					searchSuccess = true;
					break;
				}
		
			//Finding a transporter part
			case 2:
				if((searchScore + searchSkill) > 50){
					planet.setPartFound(true);
					searchSuccess = true;
					result = name + " found a transporter part!";
					crew.setCurrentPieces(crew.getCurrentPieces() + 1);
					break;
				}
			
		
			if(searchSuccess == false) {
				result = "The search was unsuccessful, " + name + " found nothing!";
			}
				
		}
		
		return result + isExhausted();
	}
	
}
