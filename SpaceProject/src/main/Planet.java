package main;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Represents the planet the user is currently on. stores whether the part has been found and the items available for sale
 * Resets when the user pilots to a new planet
 */
public class Planet {
	/** A boolean representing if the part stored on the planet has been found by the player */
	public boolean partFound;
	
	/** An ArrayList of all possible items the planet could have */
	public ArrayList<Item> allItems = new ArrayList<Item>();
	
	/** An ArrayList of the current items the planet has */
	public ArrayList<Item> planetsItems;
	
	public Planet() {
		allItems.add(new FoodItem("Dehydrated Chicken roast", 75, 100, "<html>Hearty meal after a long day in space,<br> restores a large amount of hunger.</html>"));
		allItems.add(new FoodItem("Skylab Candy Bar", 20 , 15, "<html>A bar of space candy, <br> restores a small amount of hunger</html>"));
		allItems.add(new FoodItem("Gemini Pouched Apple Juice", 50, 50, "<html>A refreshing drink to quench your thirst,<br> restores a moderate amount of hunger.</html>"));
		allItems.add(new FoodItem("Apollo Brownie Cubes ", 55, 70, "<html>Satisfies your sweet cravings,<br> restores a moderate amount of hunger.</html>"));
		allItems.add(new FoodItem("Thermostabilised Ribs ", 85, 125, "<html>Delicious rack of ribs,<br> restores a large amount of hunger</html>"));
		allItems.add(new FoodItem("Unidentified Food Packet", 10, 10, "<html>Discovered on the planet,<br> restores a small amount of hunger.</html>"));
		allItems.add(new MedicalItem("Anti-Nausea Patch", 25, 10, "Restores a small amount of health", false));
		allItems.add(new MedicalItem("Roll of Dressing", 50, 50, "Restores a moderate amount of health", false));
		allItems.add(new MedicalItem("Alien Toe", 35, 0, "Rumoured to cure space diseases when eaten", true));
		allItems.add(new MedicalItem("Gemini Med Kit", 100, 100, "Restores a large amount of health", false));
		allItems.add(new MedicalItem("Topical Ointment", 50, 1, "The usefullness of herbal medicine is unknown", false));
		allItems.add(new MedicalItem("RX2 Antibiotics", 75, 25, "Cures space plague and restores health ", true));
		newPlanet();
		
	}
	
	/** Resets the planet, setting the part found to false and randomizing the planets items */
	public void newPlanet() {
		partFound = false;
		planetsItems = generateRandomItems();
		
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
		int numParts = 0;
		
		//Ensures only unique items in the outpost
		while (numParts < 6) {
			int itemIndex = random.nextInt(getNumTotalItems());
			Item itemToAdd = allItems.get(itemIndex);
			if(!newItems.contains(itemToAdd)) {
				newItems.add(allItems.get(itemIndex));
				numParts += 1;
			}
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
