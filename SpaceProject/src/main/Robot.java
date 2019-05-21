package main;
public class Robot extends CrewMember {
	/** 
	 * @param String name The name of the robot
	 */
	public Robot(String name) {
		super(name, 100, 0, 20, 20, 20, true, 2, "Robot");
	}
}