import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	 * @param toDecrease the amount of health to decrease the crew member by
	 * @param crew the crew the crew member is from
	 */
	public void decreaseHealth(int toDecrease, Crew crew) {
		currentHealth = Math.max(currentHealth - toDecrease, 0);
		if(currentHealth == 0) {
			crewMemberDeath(crew);
		}
	}
	
	/**
	 * Increases the crew members tiredness by their tiredness increase rate
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
	 * @param actions the number of actions the crew member has now completed
	 */
	public void setActionsCompleted(int actions) {
		actionsCompleted = actions;
	}
	
	public int getAvailableActions() {
		return actionsPerDay - actionsCompleted;
	}
	
	/**
	 * 
	 * @param crew
	 */
	public void crewMemberDeath(Crew crew) {
		System.out.println(name + " has died!"); 
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
	 * @param increase the amount of health to increase the crew member by
	 */
	public void incraseHealth(int increase) {
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
		if(actionsCompleted >= actionsPerDay) {
			System.out.println(name + " Has no actions left! Use a different crew member!");
		}
		
		else if (currentTiredness == 0) {
			System.out.println(name + " Is exhausted and cannot perform any actions until the next day! Use a different crew member!");
		}
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
	 * @param plague a boolean value, true if the member is given plague, false if the member is cured.
	 */
	public void setSpacePlague(boolean plague) {
		hasPlague = plague;
	}
	
	/**
	 * Checks if a crew member has reached maximum tiredness. Will not be able to perform an action if member is exhausted.
	 * @return exhausted a boolean value, true if the member is exhausted, false if the member is not exhausted.
	 */
	public boolean isExhausted() {
		boolean exhausted = false;
		if (currentTiredness == 0) {
			setActionsCompleted(actionsPerDay);
			System.out.println(name + " is exhausted!");
			System.out.println(name + " cannot perform any more actions until the next day and will be forced to take a nap");
			exhausted = true;
		}
		
		return exhausted;
	}
	
	
	public void nap() {
		currentTiredness += 20;
		setActionsCompleted(1);
		System.out.println(name + " was forced to take a nap from exhaustion, this counts as a player action.");
	}
	
	
	/**
	 * A crew member uses an item. The crew member benefits from the item and it is removed from the crews inventory
	 * @param crew the crew the crew member is from
	 * @param userInput an integer representing the item the player has chosen to use
	 */
	public void useItem(Crew crew, int userInput) {
		if(crew.getItem(userInput) instanceof MedicalItem){
			MedicalItem itemChosen = (MedicalItem) crew.getItem(userInput);
			currentHealth = Math.min(currentHealth + itemChosen.getBenefit(), maxHealth);
			System.out.println(name + " has used a medical supply");
			
			if(itemChosen.doesCurePlauge()) {
				hasPlague = false;
				System.out.println(name + " has been cured of the space plague!");
			};
		}
		else {
			FoodItem itemChosen = (FoodItem) crew.getItem(userInput);
			currentHunger = Math.min(currentHunger + itemChosen.getBenefit(), maxHunger);
			System.out.println(name + " has eaten food");
		}
		
		//GETS THE ITEM CHOSEN > USER INPUT IS HAS -1 TO INDEX ARRAY LIST CORRECTLY WHEN getItem IS CALLED
//		Item itemChosen = crew.getItem(userInput);
//		
//		//When the item chosen is of type food
//		if (itemChosen.getType() == "food") {
//			currentHunger = Math.min(currentHunger + itemChosen.getBenefit(), maxHunger);
//			System.out.println(name + " has eaten food");
//		}
//		//When the item chosen is of type medical
//		else {
//			//casts the item to type medical
//			//MedicalItem itemChose = (MedicalItem) itemChosen;
//			MedicalItem medicalItemChosen = (MedicalItem) itemChosen;
//			currentHealth = Math.min(currentHealth + itemChosen.getBenefit(), maxHealth);
//			System.out.println(name + " has used a medical supply");
//			if(medicalItemChosen.doesCurePlauge()) {
//				hasPlague = false;
//				System.out.println(name + " has been cured of the space plague!");
//			};
			
		
		
		//Actions completed increases by 1
		//useItem(crew, userInput);
		actionsCompleted += 1;
		
		//Remove from the inventory once the item has been used
		crew.removeInInventory(userInput);
		
		increaseTiredness();
		
		isExhausted();
		
	}
	
	/**
	 * Decreases the crew members tiredness, uses an action and increases hunger
	 */
	public void sleep(){
		actionsCompleted += 1;
		System.out.println(name + " has slept");
		increaseHunger();
		currentTiredness = maxTiredness;
	}
	
	/**
	 * Uses two crew members to pilot the ship to another planet
	 * @param otherMember The other crew member piloting the ship
	 * @param planet The planet the crew member is currently on
	 * @param randomEvent instance of random event used to create the asteroid event
	 * @param ship the ship to be piloted
	 */
	public void pilotShip(CrewMember otherMember, Planet planet, RandomEvent randomEvent, Ship ship) {
		System.out.println(name + " and " + otherMember.name + " have piloted the ship");
		actionsCompleted += 1;
		otherMember.actionsCompleted += 1;
		increaseHunger();
		otherMember.increaseHunger();
		increaseTiredness();
		otherMember.increaseTiredness();
		isExhausted();
		otherMember.isExhausted();
		planet.newPlanet();
		randomEvent.asteroidBelt(ship);
	}

	/**
	 * Repairs the ships shields by the crew members specified repair skill
	 * @param ship the ship to be repaired
	 */
	public void repairShields(Ship ship) {
		if(ship.getCurrentShieldLevel() == ship.getMaxShieldLevel()) {
			System.out.println("The shields are already at full health!");
		}
		else {
		ship.setShieldLevel(Math.min(ship.getMaxShieldLevel(), ship.getCurrentShieldLevel() + repairSkill));
		System.out.println(name + " has repaired the ships shields");
		ship.printStatus();
		increaseHunger();
		increaseTiredness();
		actionsCompleted += 1;
		
		isExhausted();
		}
	}
	
	/** 
	 * A crew member searches the planet for parts. They can find a spaceship part, an item, money or nothing
	 * @param planet the planet to be searched
	 * @param crew the crew that the member is from
	 */
	public void searchForParts(Planet planet, Crew crew) {
		increaseHunger();
		increaseTiredness();
		actionsCompleted += 1;
		
		isExhausted();
		
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
				if((searchScore + searchSkill) > 50){
					int moneyGained = random.nextInt(60);
					crew.addMoney(moneyGained);
					searchSuccess = true;
					System.out.println("You found $" + moneyGained);
					break;
				}
				
				//Finding an item
			case 1:
				if((searchScore + searchSkill) > 100){
					int itemIndex = random.nextInt(planet.getNumTotalItems());
					Item itemFound = planet.getAllItems().get(itemIndex);
					crew.addItem(itemFound);
					System.out.println("You have found " + itemFound.getName() + " of type " + itemFound.getType());
					searchSuccess = true;
					break;
				}
		
			//Finding a transporter part
			case 2:
				if((searchScore + searchSkill) > 100){
					planet.setPartFound(true);
					searchSuccess = true;
					System.out.println("You found a transporter part!");
					crew.setCurrentPieces(crew.getCurrentPieces() + 1);
					System.out.println("You have found " + crew.getCurrentPieces() + "/" + crew.getPiecesToFind() + " of the transporter parts!");
					break;
				}
			
		
			if(searchSuccess == false) {
				System.out.println("The search was unsuccessful, you found nothing!");
			}
				
		}
	}
	
}
