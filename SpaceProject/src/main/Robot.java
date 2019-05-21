package main;
/**
 * Robot is a subclass of CrewMember
 * Robots have the unique attribute of not getting hungry and being immune to space plague
 */
public class Robot extends CrewMember {
	/** 
	 * @param String name The name of the robot
	 */
	public Robot(String name) {
		super(name, 100, 0, 20, 20, 20, true, 2, "Robot");
	}
}