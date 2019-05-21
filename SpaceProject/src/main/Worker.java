package main;
public class Worker extends CrewMember {
	
	/**
	 * @param String name The name of the crew member
	 */
	public Worker(String name) {
		super(name, 100, 25, 25, 20, 20, false, 3, "Worker");
	}
}