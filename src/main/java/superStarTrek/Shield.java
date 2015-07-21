package superStarTrek;

/**
 * Represents a shield, which uses energy to protect our ship.
 *
 */
public class Shield extends Subsystem {
	public void raise() {
		up = true;
	}
	
	public int transferAndReturnUnused(int amt) { 
		int remain = 0;
		if (energy + amt < MAX_ENERGY) {
			addEnergy( amt);	
		}
		else {
			remain = amt - (MAX_ENERGY - energy);
			addEnergy( MAX_ENERGY - energy);	
		}
		
		return remain;
	}
	
	

}
