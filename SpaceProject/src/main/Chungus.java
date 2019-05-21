package main;
/**
 * Chungus is a subclass of CrewMember
 * Chunguses have the unique attribute of having an extra 50 health
 */
public class Chungus extends CrewMember {
	/**
	 * 
	 * @param String name The name of the Chungus
	 */
	public Chungus(String name) {
		super(name, 150, 20, 20, 20, 20, false, 2, "Chungus");
	}
}
