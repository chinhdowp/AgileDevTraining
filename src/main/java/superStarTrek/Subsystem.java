package superStarTrek;

public class Subsystem {
	protected boolean up = false;
	private int energy;
	private int health; // stardates

	public boolean isUp() {
		return up;
	}

	public int energy() {
		return energy;
	}

	protected void setEnergy(int value) {
		energy = value;
		if (energy <= 0) {
			up = false;
		}
	}

	public Subsystem() {
		super();
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

}