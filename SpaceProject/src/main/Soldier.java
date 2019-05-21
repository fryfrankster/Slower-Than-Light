package main;
/**
 * Solider is a subclass of CrewMember
 * Soldiers have the unique attribute of not getting tired or hungry as easily
 */
public class Soldier extends CrewMember {
	/**
	 * @param String name the name of the soldier
	 */
	public Soldier(String name) {
		super(name, 100, 10, 10, 20, 20, false, 2, "Soldier");
	}
}