package superStarTrek;

/**
 * Represents a shield, which uses energy to protect our ship.
 *
 */
public class Shield extends Subsystem {
	public static final int INITIAL_ENERGY = 5000;
	
	public Shield() {
		setEnergy(INITIAL_ENERGY);
	}
	
	public void raise() {
		up = true;
	}
	
	public int transferAndReturnUnused(int amt) { 
		int remain = 0;
		if (energy + amt < MAX_ENERGY) {
			setEnergy(energy + amt);	
		}
		else {
			remain = amt - (MAX_ENERGY - energy);
			setEnergy(energy + MAX_ENERGY - energy);	
		}
		
		return remain;
	}
	
	

}
