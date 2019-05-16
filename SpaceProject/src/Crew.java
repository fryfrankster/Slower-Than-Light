import java.util.ArrayList;
import java.util.Iterator;


/** Stores information about crew members, their ship, and their current inventory.
*/
public class Crew {
	/** Stores the name the user chooses for the crew */
	private String name;

	/** The number of pieces the player has found of the ship */
	private int currentPieces;
	
	/** The total number of ship pieces the player has to find */
	private int piecesToFind;
	
	/** Stores the amount of money the crew has */
	private int money;
	
	/** Stores the CrewMembers of the crew*/
	private ArrayList<CrewMember> crewMembers;
	
	/** Stores the items the crew has */
	private ArrayList<Item> items;
	
	
	public String getName() {
		return name;
	}
	
	/**
	 * Adds an object of type CrewMember to the crew
	 * @param CrewMember crewMember object of type crew member to be added
	 */
	public void addCrewMember(CrewMember crewMember) {
		crewMembers.add(crewMember);
		System.out.println("You have added a crew member called " + crewMember.getName() + " of type " + crewMember.getType() + "!");
	}
	
	/**Returns the amount of money the crew has
	 * @return the integer amount of money the crew has
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * Removes a crew member from the crew
	 * @param CrewMember crewMember The crew member to be removed
	 */
	public void removeCrewMember(CrewMember crewMember) {
		crewMembers.remove(crewMember);
	}
	
	
	/**
	 * Decreases the crew's money 
	 * @param int toDecrease the amount of money lost
	 */
	public void decreaseMoney(int toDecrease) {
		money -= toDecrease;
	}
	
	
	/**
	 * Returns the size of the crew
	 * @return the size of the list of crew members in the crew
	 */
	public int getCrewSize() {
		return crewMembers.size();
	}
	
	
	/**
	 * returns an ArrayList of the crew's members
	 * @return The ArrayList of the crew's crew members 
	 */
	public ArrayList<CrewMember> getCrewMembers(){
		return crewMembers;
	}
	
	/**
	 * Returns the items that the crew has
	 * @return the ArrayList of crews items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Allows the crew to purchase an item from a space outpost
	 * @param Crew crew the crew purchasing the item
	 * @param Planet planet the planet the item is being purchased from
	 * @param int itemIndex the index of the item in the planets list of items
	 */
	public void purchaseItem(Crew crew, Planet planet, int itemIndex) {
		//Case they can afford item
		Item itemToPurchase = planet.getPlanetsItems().get(itemIndex);
		if (crew.getMoney() >= itemToPurchase.getPrice()) {
			crew.decreaseMoney(itemToPurchase.getPrice());
			crew.addItem(itemToPurchase);
			planet.removeItem(itemIndex);
			System.out.println("You have purchased " + itemToPurchase.getName() + "!");
		}
		
		//If they can't afford the item
		else {
			System.out.println("YOU CANNOT AFFORD THIS ITEM!");
		}
	}
	
	/**
	 * Returns the size of the crews inventory
	 * @return the size of the crews inventory as an integer
	 */
	public int getInventorySize() {
		return items.size();
	}
	
	/**
	 * Resets crew Member actions to 0 and decreases a crew member's health if they have space plague
	 */
	public void resetCrewActions() {

		//Have to do it this way with iterator because of issues with space plague
		for (Iterator<CrewMember> iterator = crewMembers.iterator(); iterator.hasNext(); ) {
		    CrewMember member = iterator.next();
		    member.setActionsCompleted(0);
		    
		    if (member.getTiredness() == 0) {
		    	member.nap();
		    }
		    
		    if (member.hasSpacePlague()) {
		    	if (member.getHealth() > 35) {
		        member.decreaseHealth(35, this);
		        System.out.println(member.getName() + " has lost 35 health from space plauge! Their current health is " + member.getHealth() + "/" + member.getMaxHealth());
		    	}
		    	else {
		    		iterator.remove();
		    		System.out.println(member.getName() + " has died from space plague!"); 
		    	}
		    }

		    else if (member.getHunger() <= 0) {
		    	if (member.getHealth() > 25) {
			        member.decreaseHealth(25, this);
			        System.out.println(member.getName() + " has lost 35 health due to starvation! Their current health is " + member.getHealth() + "/" + member.getMaxHealth());
			    	}
			    else {
			    	iterator.remove();
			    	System.out.println(member.getName() + " has died from hunger!!"); 
			    }
		    }
		    
		 
		    
		}
		
	}
	
	/**
	 * Calculates the users score for the day
	 * @return the increase in users score
	 */
	public int getDailyScore() {
		int totalHealth = 0;
		int maxHealth = 0;
		int totalTireness = 0;
		int maxTiredness = 0;
		int totalHunger = 0;
		int maxHunger = 0;
		int scoreIncrease = 0;
		
		for(CrewMember crewMember: crewMembers) {
			totalHealth += crewMember.getHealth();
			maxHealth += crewMember.getMaxHealth();
			totalTireness = crewMember.getTiredness();
			maxTiredness += crewMember.getMaxTiredness();
			totalHunger += crewMember.getMaxHunger();
			maxHunger += crewMember.getMaxHunger();
			//Account for number of days
		}
		scoreIncrease += (int) Math.round(100 * (totalHealth / maxHealth) + 100 * (totalHunger / maxHunger) + 100 * (totalTireness / maxTiredness));
		
		return scoreIncrease;
	}
	
	
	/**
	 * Prints the amount of money the crew has
	 */
	public void printCurrentMoney() {
		System.out.println("Your crew currently has $" + money);
	}
	
	/**
	 * Checks if the crew's inventory is empty
	 * @return a boolean if the crews inventory is empty.
	 */
	public boolean isInventoryEmpty() {
		return items.isEmpty();
	}
	
	/**
	 * Returns an item the crew owns
	 * @param int  userInput the index of the item in the crew's item list
	 * @return The Item object at the specified index in the crew's item list
	 */
	public Item getItem(int userInput) {
		return items.get(userInput - 1);
	}
	
	/**
	 * Removes an item from the crews inventory
	 * @param int userInput the index of the item to remove
	 */
	public void removeInInventory(int userInput) {
		items.remove(userInput - 1);
	}
	
	
	/**
	 * Increases the amount of money the crew has
	 * @param int moneyToAdd the amount to increase the crew's money by
	 */
	public void addMoney(int moneyToAdd) {
		money += moneyToAdd;
	}
	
	
	/**
	 * Adds an item to the crew's inventory
	 * @param Item the item to be added
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	
	/**
	 * 
	 * @param crewName the name of the crew
	 */
	public Crew(String crewName) {
		crewMembers = new ArrayList<CrewMember>();
		items = new ArrayList<Item>();
		money = 100;
		name = crewName;
		
	}
	
	/**
	 * Print's the status of all crew members
	 */
	public void printAllStatuses() {
		for(CrewMember member: crewMembers) {
			member.printStatus();
		}
	}
	
	/**
	 * Prints the items in the crews inventory
	 */
	public void viewInventory() {
		if (items.isEmpty()) {
			System.out.println("There are no items in the inventory");
		}
		else {
			int counter = 1;
			for(Item item: items) {
				System.out.println(counter + ") " + item.getInfo());
				counter += 1;
			}
		}
	}
	
	
	/**
	 * Prints the crew members that can perform actions
	 */
	public void printAvailableCrewMembers(){
		for(int i = 0; i < crewMembers.size(); i++) {
			System.out.println("Type " + (i + 1) + " to use " + crewMembers.get(i).getActionStatus());
	
		}
	
	}	
	
	public int getCurrentPieces() {
		return currentPieces;
	}
	
	public int getPiecesToFind() {
		return piecesToFind;
	}
	
	public void setCurrentPieces(int pieces) {
		currentPieces = pieces;
	}
	
	public void setPiecesToFind(int pieces) {
		piecesToFind = pieces;
	}
	
	
}
