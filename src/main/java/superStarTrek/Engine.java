package superStarTrek;

public class Engine extends Subsystem {
	public void causeDamage(int energy) {
		int years = energy % 200;
		setDamage(getDamage() + years);
	}
}
