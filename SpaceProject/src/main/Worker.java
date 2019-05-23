package main;

/**
 * Worker is a subclass of CrewMember
 * Workers have the unique attribute of having an extra action per day and getting tired/hungry easier.
 */
public class Worker extends CrewMember {
	
	/**
	 * Constructor for type Worker
	 * @param name The name of the crew member
	 */
	public Worker(String name) {
		super(name, 100, 25, 25, 20, 20, false, 3, "Worker");
	}
}