package main;
/**
 * Engineer is a subclass of CrewMember
 * Engineers have the unique attribute of repairing the ships shields more effectively
 */
public class Engineer extends CrewMember {
	/**
	 * @param name The name of the Engineer
	 */
	public Engineer(String name) {
		// TODO Auto-generated constructor stub
		super(name, 100, 20, 20, 20, 50, false, 2, "Engineer");

	}
	
}