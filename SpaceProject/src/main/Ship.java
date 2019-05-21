package main;
public class Ship {
	private String name;
	private int maxShieldLevel;
	private int currentShieldLevel;
	
	public Ship(String name) {
		this.name = name;
		currentShieldLevel = maxShieldLevel = 100;
	}
	
	public int getCurrentShieldLevel() {
		return currentShieldLevel;
	}
	
	public int getMaxShieldLevel() {
		return maxShieldLevel;
	}
	
	public void setShieldLevel(int newLevel){
		currentShieldLevel = newLevel;
	}
	
	public void decreaseShieldLevel(int decrease) {
		currentShieldLevel -= decrease;
	}
	
	public String getName() {
		return name;
	}
	
	
}
