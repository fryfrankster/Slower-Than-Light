import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Planet {
	/** A boolean representing if the part stored on the planet has been found by the player */
	public boolean partFound;
	
	/** An ArrayList of all possible items the planet could have */
	public ArrayList<Item> allItems = new ArrayList<Item>();
	
	/** An ArrayList of the current items the planet has */
	public ArrayList<Item> planetsItems;
	
	public Planet() {
		allItems.add(new FoodItem("Space Candy", 20, 10, "Restores a small amount of hunger"));
		allItems.add(new FoodItem("Cheese", 50 , 30, "Restores a moderate amount of hunger"));
		allItems.add(new FoodItem("Spare Ribs", 70, 70, "Restores a large amount of hunger"));
		allItems.add(new FoodItem("Food1", 70, 70, "Very delicious food1"));
		allItems.add(new FoodItem("Food2", 70, 70, "Very delicious food2"));
		allItems.add(new FoodItem("Unknown Plant", 30, 15, "Restores a small amount of hunger"));
		allItems.add(new MedicalItem("Band Aid", 25, 10, "Restores a small amount of health", false));
		allItems.add(new MedicalItem("Space Painkillers", 50, 50, "Restores a moderate amount of health", false));
		allItems.add(new MedicalItem("Alien Toe", 35, 0, "Rumoured to cure space diseases when eaten", true));
		allItems.add(new MedicalItem("Medical Kit", 100, 100, "Restores a large amount of health", false));
		allItems.add(new MedicalItem("Herbal Medicine", 50, 1, "The usefullness of herbal medicine is unknown", false));
		allItems.add(new MedicalItem("Alien antibiotics", 75, 25, "Cures space plague and restores health ", true));
		newPlanet();
		
	}
	
	/** Resets the planet, setting the part found to false and randomizing the planets items */
	public void newPlanet() {
		partFound = false;
		planetsItems = generateRandomItems();
		
	}
	
	/**
	 * Prints item's that the planet has available for purchase
	 */
	public void printPurchasableItems() {
		int counter = 1;
		for(Item item: planetsItems) {
			int itemFrequency = Collections.frequency(planetsItems, item);
			System.out.println(counter + ") " + itemFrequency + " available) "+ item.getInfo());
			counter += 1;
		}
		
	}
	
	/** 
	 * Returns the amount of items the planet has for sale
	 * @return the length of the planets items Array List
	 */
	public int getPlanetsItemsSize() {
		return planetsItems.size();
	}
	
	/**
	 * Picks random items from the list of all possible items
	 * @return an ArrayList with 6 random items
	 */
	private ArrayList<Item> generateRandomItems(){
		ArrayList<Item> newItems = new ArrayList<Item>();
		Random random = new Random();
		for(int x = 0; x < 6; x++) {
			int itemIndex = random.nextInt(getNumTotalItems());
			newItems.add(allItems.get(itemIndex));
		}
	return newItems;
	}
	
	
	/**
	 * returns the items the planet has for sale
	 * @return the ArrayList of Items that the planet has for sale
	 */
	public ArrayList<Item> getPlanetsItems() {
		return planetsItems;
	}
	
	/**
	 * Removes an item from the ArrayList of items the planet has for sale
	 * @param int index the index of the item to remove
	 */
	public void removeItem(int index) {
		planetsItems.remove(index);
	}
	
	/**
	 * Checks if the part has been found on the planet
	 * @return a boolean representing if the part has been found
	 */
	public boolean partFound() {
		return partFound;
	}
	
	
	/**
	 * Returns all the possible items a planet could have
	 * @return an ArrayList of all possible items
	 */
	public ArrayList<Item> getAllItems(){
		return allItems;
	}
	
	
	/**
	 * Returns the number of items the planet could have
	 * @return the length of the ArrayList of total items the planet could have
	 */
	public int getNumTotalItems() {
		return allItems.size();
	}
	
	
	/**
	 * Sets whether the planet's part has been found or not
	 * @param boolean found whether or not the planet's part has been found
	 */
	public void setPartFound(boolean found) {
		partFound = found;
	}
}
