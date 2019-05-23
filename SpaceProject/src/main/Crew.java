package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;


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
	
	/** Returns if the player has found all the ships parts*/
	public boolean foundAllParts() {
		return currentPieces == piecesToFind;
	}
	
	/** Returns The name the user has chosen for the crew */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds an object of type CrewMember to the crew members Array List
	 * @param CrewMember crewMember object of type crew member to be added to the crew members list
	 */
	public void addCrewMember(CrewMember crewMember) {
		crewMembers.add(crewMember);
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
	 * @param int toDecrease the amount of money lost by the crew
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
	 * Returns an ArrayList of the crew's members
	 * @return The ArrayList of type CrewMember holding the crew's crew members 
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
		crew.decreaseMoney(itemToPurchase.getPrice());
		crew.addItem(itemToPurchase);
		planet.removeItem(itemIndex);
	
		
	}
	
	/**
	 * Returns an integer showing how many crew members can complete actions on the current day
	 * @return an integer showing how many crew members can complete actions on the current day
	 */
	public int getAvailableCrewMembers() {
		int availableMembers = 0;
		for(CrewMember crewMember: crewMembers) {
			if(crewMember.canPerformAction()) {
				availableMembers += 1;
			}
		}
		return availableMembers;
	}
	
	/**
	 * Returns a boolean value showing if the crew has enough money to purchase an item
	 * @param Crew crew The crew attempting to purchase an item
	 * @param Planet planet The planet the crew is purchasing the item from
	 * @param int itemIndex The index of the item in the planets item list the crew wishes to purchase
	 * @return A boolean showing if the crew has enough money to purchase an item
	 */
	public boolean canPurchaseItem(Crew crew, Planet planet, int itemIndex) {
		return crew.getMoney() >= planet.getPlanetsItems().get(itemIndex).getPrice();
	}
	
	/**
	 * Returns the size of the crews inventory
	 * @return the size of the crews inventory as an integer
	 */
	public int getInventorySize() {
		return items.size();
	}
	
	/**
	 * Resets crew Member actions to 0 and decreases a crew member's health if they have space plague or are missing hunger
	 */
	public void resetCrewActions() {

		for (Iterator<CrewMember> iterator = crewMembers.iterator(); iterator.hasNext(); ) {
		    CrewMember member = iterator.next();
		    member.setActionsCompleted(0);
		    
		    if (member.getTiredness() == 0) {
		    	member.nap();
		    }
		    
		    if (member.hasSpacePlague()) {
		    	if (member.getHealth() > 35) {
		    		member.decreaseHealth(35, this);
		    	}
		    	else {
		    		iterator.remove();
		    	}
		    }

		    else if (member.getHunger() <= 0) {
		    	if (member.getHealth() > 25) {
			        member.decreaseHealth(25, this);
			       
			    	}
			    else {
			    	iterator.remove();

			    }
		    }
		    
		 
		    
		}
		
	}
	
	/**
	 * Calculates the players score for the day
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
	 * Checks if the crew's inventory is empty
	 * @return a boolean if the crews inventory is empty.
	 */
	public boolean isInventoryEmpty() {
		return items.isEmpty();
	}
	
	/**
	 * Returns an item the crew owns at the desired index
	 * @param int  userInput the index of the item in the crew's item list
	 * @return The Item object at the specified index in the crew's item list
	 */
	public Item getItem(int userInput) {
		return items.get(userInput);
	}
	
	/**
	 * Removes an item from the crews inventory
	 * @param int userInput the index of the item to remove
	 */
	public void removeInInventory(int userInput) {
		items.remove(userInput);
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
	 * Constructor for Object of Type Crew
	 * Initializes crews starting money, crew members, items and name.
	 * @param String crewName the name of the crew
	 */
	public Crew(String crewName) {
		crewMembers = new ArrayList<CrewMember>();
		items = new ArrayList<Item>();
		money = 10000;
		name = crewName;
		
	}
	
	/**
	 * Returns the crews items as a string array for display in the drop down selection box in the GUI
	 * @return A String Array showing items and their frequencies.
	 */
	public String[] getItemsAsStringArray(){
		ArrayList<String> crewsItemsNames = new ArrayList<>();
		
		for(Item item: items) {
			crewsItemsNames.add(item.getName());
		}
		
		LinkedHashSet<String> crewsItemSet = new LinkedHashSet<String>(crewsItemsNames);
		String[] choices = new String[crewsItemSet.size()];
		
		int index = 0;
		for(String name : crewsItemSet) {
			choices[index] = String.valueOf(index) + ": " + name + " (" + Collections.frequency(crewsItemsNames, name) + ")";
			index += 1;
		}

		return choices;
	}
	
	/**
	 * Returns the amount of ship pieces the crew has found
	 * @return an integer showing the amount of ship pieces the crew has found
	 */
	public int getCurrentPieces() {
		return currentPieces;
	}
	
	/**
	 * Return the amount of total ship pieces the crew has to find
	 * @return an integer showing the total amount of ship pieces the crew has to find
	 */
	public int getPiecesToFind() {
		return piecesToFind;
	}
	
	
	/**
	 * Sets the current pieces that the crew has found to the parameter
	 * @param int pieces an integer representing how many pieces the crew has found
	 */
	public void setCurrentPieces(int pieces) {
		currentPieces = pieces;
	}
	
	
	/**
	 * Sets the total pieces that the crew has to find to the parameter
	 * @param int pieces an integer representing how many total pieces the crew has to find
	 */
	public void setPiecesToFind(int pieces) {
		piecesToFind = pieces;
	}
	
	
}
