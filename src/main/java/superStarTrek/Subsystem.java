package superStarTrek;

public class Subsystem {

	public static final int MAX_ENERGY = 10000;
	protected boolean up = false;
	private int energy;

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