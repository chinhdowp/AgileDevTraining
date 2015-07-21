package superStarTrek;

public class Subsystem {

	public static final int MAX_ENERGY = 10000;
	protected boolean up = false;

	public boolean isUp() {
		return up;
	}

	public int energy() {
		return energy;
	}

	protected void addEnergy(int value) {
		energy += value;
		if (energy<=0)
			up = false;
	}

	protected int energy = 5000;

	public Subsystem() {
		super();
	}

	public int takeHit(int damage) {
		int extraDamage = 0;
		
		if(energy > damage)
			addEnergy(-damage);
		else{
			extraDamage = damage - energy;
			energy = 0;  // TODO
			up = false;
		}
		
		return extraDamage;
	}

}