package superStarTrek;

public class Phaser extends Subsystem {
	public void causeDamage(int energy) {
		int years = energy % 300;
		setDamage(getDamage() + years);
	}
}
