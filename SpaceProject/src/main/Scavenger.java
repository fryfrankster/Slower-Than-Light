package main;
/**
 * Scavenger is a subclass of CrewMember
 * Scavengers have the unique attribute of being more likely to find items from planets
 */
public class Scavenger extends CrewMember {
	/**
	 * @param String name The name of the scavenger
	 */
	public Scavenger(String name) {
		super(name, 100, 20, 20, 50, 20, false, 2, "Scavenger");
	}
}