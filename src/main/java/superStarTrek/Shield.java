package superStarTrek;

/**
 * Represents a shield, which uses energy to protect our ship.
 *
 */
public class Shield extends Subsystem {
	public static final int INITIAL_ENERGY = 5000;
	public static final int MAX_ENERGY = 10000;
	protected boolean up = false;
	private int energy;
	
	public Shield() {
		setEnergy(INITIAL_ENERGY);
	}
	
	public int getEnergy() {
		return energy;
	}
	
	protected void setEnergy(int value) {
		energy = value;
		if (energy <= 0) {
			up = false;
		}
	}
	
	public int takeHit(int damage) {
		int extraDamage = 0;
		
		if(energy > damage)
			setEnergy(energy - damage);
		else{
			extraDamage = damage - energy;
			setEnergy(0);
		}
		
		return extraDamage;
	}
	
	public boolean isUp() {
		return up;
	}
	
	public void raise() {
		up = true;
	}
	
	public void causeDamage(int energy) {
		int years = energy % 5;
		setDamage(getDamage() + years);
	}
	
	public int transferAndReturnUnused(int amt) { 
		int remain = 0;
		if (getEnergy() + amt < MAX_ENERGY) {
			setEnergy(getEnergy() + amt);	
		}
		else {
			remain = amt - (MAX_ENERGY - getEnergy());
			setEnergy(getEnergy() + MAX_ENERGY - getEnergy());	
		}
		
		return remain;
	}
	
	

}
