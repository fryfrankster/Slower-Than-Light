package main;
import java.util.Random;

/**
 * Stores logic about random events in the game such as space pirates, space plague and asteroids.
 */
public class RandomEvent {

	/** Used for random chances */
	Random random = new Random();
	
	/**
	 * When called there is a 20% chance Alien Pirates will attack the crew, stealing a random item from their inventory
	 * @param Crew crew The crew the alien pirates are attacking
	 */
	public String alienPirates(Crew crew) {
		int chance = random.nextInt(10);

		if(chance <= 2 & crew.getInventorySize() != 0) {
			int indexToRemove = random.nextInt(crew.getInventorySize());
			Item removedItem = crew.getItems().remove(indexToRemove);
			return " Space pirates invaded and stole your " + removedItem.getName() + "!";
		}
			
		return "";
	}
	
	
	/** 
	 * When called there is a 20% chance a crew member will get space plague.
	 * @param Crew crew The crew that is being effected by space plague
	 */
	public String spacePlague(Crew crew) {
		if(crew.getCrewSize() > 0){
		int chance = random.nextInt(10);

		if(chance <= 20) {
			int crewMemberIndex = random.nextInt(crew.getCrewSize());
			CrewMember crewMember = crew.getCrewMembers().get(crewMemberIndex);
			if(crewMember.hasSpacePlague() == false && crewMember.isPlaugeImmune() == false) {
				crewMember.setSpacePlague(true);
				return  " " + crewMember.getName() + " has caught the space plauge!";
			}
			
		}
		}
		return "";
			
		
		
	}
	
	/**
	 * When called there is a 30% chance the ship will hit an asteroid belt, reducing it's shield health by an amount that scales off missing health
	 * @param Ship ship the ship that hits the asteroid belt
	 */
	public String asteroidBelt(Ship ship) {
		int chance = random.nextInt(10);
		if(chance <= 2) {
			int damage = (int) (15 + Math.floor((ship.getMaxShieldLevel() - ship.getCurrentShieldLevel())) * 0.5);
			ship.decreaseShieldLevel(damage);
			return " They crashed into asteroids casusing " + damage + " damage to the ship!";
		}
		else {
			return "";
		}
	}
	
}
