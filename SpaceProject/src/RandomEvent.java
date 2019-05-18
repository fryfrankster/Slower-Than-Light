import java.util.Random;

public class RandomEvent {

	/** Used for random chances */
	Random random = new Random();
	
	/**
	 * When called there is a 20% chance Alien Pirates will attack the crew, stealing a random item from their inventory
	 * @param Crew crew The crew the alien pirates are attacking
	 */
	public void alienPirates(Crew crew) {
		int chance = random.nextInt(10);
		if(chance <= 2 & crew.getInventorySize() != 0) {
			int indexToRemove = random.nextInt(crew.getInventorySize());
			Item removedItem = crew.getItems().remove(indexToRemove);
			System.out.println("Space pirates have invaded your ship and stole your" + removedItem.getName() + "!");
		}
			
	}
	
	
	/** 
	 * When called there is a 20% chance a crew member will get space plague.
	 * @param crew The crew that is being effected by space plague
	 */
	public void spacePlague(Crew crew) {
		int chance = random.nextInt(10);
		//SHOULD BE 2
		if(chance <= 100) {
			int crewMemberIndex = random.nextInt(crew.getCrewSize());
			CrewMember crewMember = crew.getCrewMembers().get(crewMemberIndex);
			if(crewMember.hasSpacePlague() == false && crewMember.isPlaugeImmune() == false) {
				crewMember.setSpacePlague(true);
				System.out.println(crewMember.getName() + " has caught the space plauge, they will lose health daily until cured!");
			}
			
		}
			
		
		
	}
	
	/**
	 * When called there is a 30% chance the ship will hit an asteroid belt, reducing it's shield health by an amount that scales off missing health
	 * @param ship the ship that hits the asteroid belt
	 */
	public void asteroidBelt(Ship ship) {
		int chance = random.nextInt(10);
		if(chance <= 2) {
			int damage = (int) (15 + Math.floor((ship.getMaxShieldLevel() - ship.getCurrentShieldLevel())) * 0.5);
			System.out.println("You've crashed into an asteroid belt while on the way to the new planet, the ship took " + damage + " damage!");
			ship.decreaseShieldLevel(damage);
			ship.printStatus();			
		}
	}
	
}
