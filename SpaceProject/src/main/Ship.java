package main;

/**
 * Contains information about the players ship such as it's name and shield level
 */
public class Ship {
	
	/** The name of the ship */
	private String name;
	
	/** The ships maximum shield level */
	private int maxShieldLevel;
	
	/** The ships current shield level */
	private int currentShieldLevel;
	
	/**
	 * Constructor for the ship
	 * @param String name the name of the ship
	 */
	public Ship(String name) {
		this.name = name;
		currentShieldLevel = maxShieldLevel = 100;
	}
	
	/**
	 * Returns the ships current shield level as an int
	 * @return the ships current shield level
	 */
	public int getCurrentShieldLevel() {
		return currentShieldLevel;
	}
	
	/**
	 * Returns the ships maximum shield level as an int
	 * @return the ships maximum shield level
	 */
	public int getMaxShieldLevel() {
		return maxShieldLevel;
	}
	
	/**
	 * Sets the ships shield level
	 * @param int newLevel the level to set the ships shields to
	 */
	public void setShieldLevel(int newLevel){
		currentShieldLevel = newLevel;
	}
	
	/**
	 * Decreases the ships shield level
	 * @param int decrease the amount to decrease the shields by
	 */
	public void decreaseShieldLevel(int decrease) {
		currentShieldLevel -= decrease;
	}
	
	/**
	 * Returns the name of the ship
	 * @return the name of the ship
	 */
	public String getName() {
		return name;
	}
	
	
}
